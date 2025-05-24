package com.ortega.exepciones.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ortega.exepciones.services.FileContent;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/files")
public class FileController {
  private final FileContent fileContent;

  public FileController(FileContent fileContent) {
    this.fileContent = fileContent;
  }

  @GetMapping("/lectura")
  public ResponseEntity<String> readFile(@RequestParam String filePath) {
    try {
      String content = fileContent.readFile(filePath);
      return ResponseEntity.ok(content);
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Error reading file: " + e.getMessage());
    }
  }
}