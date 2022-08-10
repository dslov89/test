package com.umc.mwomeokji.infra.s3;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String uploadImage(MultipartFile multipartFile);

    void deleteImage(String fileName);
}
