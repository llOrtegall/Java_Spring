package com.ortega.exepciones.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

@Service
public class FileContent {
  public String readFile(String filePath){
    try {
      Path route = Paths.get(filePath);
      return Files.readString(route);
    } catch (IOException e) {
      throw new RuntimeException("Error reading file: " + filePath + e.getMessage(), e);
    }
  }
}
