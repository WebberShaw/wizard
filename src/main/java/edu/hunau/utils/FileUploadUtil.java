package edu.hunau.utils;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadUtil {
    String uploadFile(MultipartFile file);
}
