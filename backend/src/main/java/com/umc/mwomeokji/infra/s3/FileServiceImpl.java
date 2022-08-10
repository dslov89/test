package com.umc.mwomeokji.infra.s3;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.umc.mwomeokji.global.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
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

    @Value("${cloud.aws.s3.bucket-name}")
    private String bucketName;

    @Override
    public String uploadImage(MultipartFile multipartFile) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(multipartFile.getSize());
        metadata.setContentType(MediaType.IMAGE_PNG_VALUE);
        String fileName = UUID.randomUUID().toString();
        try {
            amazonS3.putObject(bucketName, fileName, multipartFile.getInputStream(), metadata);
        } catch (IOException e) {
            e.printStackTrace();
            throw new BusinessException(FILE_IO_EXCEPTION);
        } catch (AmazonServiceException e) {
            e.printStackTrace();
            throw new BusinessException(AMAZON_SERVICE_EXCEPTION);
        } catch (SdkClientException e) {
            e.printStackTrace();
            throw new BusinessException(SDK_CLIENT_EXCEPTION);
        }
        return fileName;
    }

    @Override
    public void deleteImage(String fileName) {
        amazonS3.deleteObject(bucketName, fileName);
    }
}
