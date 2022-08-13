package com.umc.mwomeokji.infra.s3;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.umc.mwomeokji.infra.s3.exception.AmazonException;
import com.umc.mwomeokji.infra.s3.exception.FileException;
import lombok.RequiredArgsConstructor;
import org.apache.tika.Tika;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

import static com.umc.mwomeokji.global.error.exception.ExceptionCodeAndDetails.*;

@RequiredArgsConstructor
@Service
public class FileServiceImpl implements FileService {

    private final AmazonS3 amazonS3;
    private final Tika tika = new Tika();

    @Value("${cloud.aws.s3.bucket-name}")
    private String bucketName;

    @Value("${cloud.aws.cloudfront.url}")
    private String cloudfrontImageUrlFormat;

    @Value("${cloud.aws.s3.user-default-image}")
    private String userDefaultImageUrl;

    @Override
    public String uploadImage(MultipartFile multipartFile) {
        if (multipartFile == null){
            return makeCloudFrontUrl(userDefaultImageUrl);
        }
        fileExtensionValidator(multipartFile);
        ObjectMetadata objectMetadata = generateObjectMetadata(multipartFile);
        String fileName = generateFileName(multipartFile);
        try {
            amazonS3.putObject(bucketName, fileName, multipartFile.getInputStream(), objectMetadata);
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileException(FILE_IO_EXCEPTION);
        } catch (AmazonServiceException e) {
            e.printStackTrace();
            throw new AmazonException(AMAZON_SERVICE_EXCEPTION);
        } catch (SdkClientException e) {
            e.printStackTrace();
            throw new AmazonException(SDK_CLIENT_EXCEPTION);
        }
        return makeCloudFrontUrl(fileName);
    }

    @Override
    public void deleteImage(String fileName) {
        amazonS3.deleteObject(bucketName, fileName);
    }

    private String makeCloudFrontUrl(String fileName) {
        return String.format(cloudfrontImageUrlFormat, fileName);
    }

    private void fileExtensionValidator(MultipartFile multipartFile) {
        try {
            String MIMEType = tika.detect(multipartFile.getBytes());
            if(!MIMEType.startsWith("image")) {
                throw new FileException(FILE_EXTENSION_EXCEPTION);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileException(FILE_IO_EXCEPTION);
        }
    }

    private ObjectMetadata generateObjectMetadata(MultipartFile multipartFile) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(multipartFile.getSize());
        objectMetadata.setContentType(MediaType.IMAGE_PNG_VALUE);
        return objectMetadata;
    }

    private String generateFileName(MultipartFile multipartFile) {
        try {
            String fileName = UUID.randomUUID().toString();
            MimeType mimeType = MimeTypes.getDefaultMimeTypes().forName(tika.detect(multipartFile.getBytes()));
            return fileName + mimeType.getExtension();
        } catch (MimeTypeException | IOException e) {
            e.printStackTrace();
            throw new FileException(FILE_EXTENSION_EXCEPTION);
        }
    }
}
