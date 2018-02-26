package com.nanta.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
  String getFilePath();

  String uploadFile(MultipartFile file, String path, String name) throws Exception;

  void deleteFile(String path, String fileName) throws Exception;

  void resizeImage(String sourcePath, int width, int height, String destination)
      throws Exception;
}
