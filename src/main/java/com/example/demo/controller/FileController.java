package com.example.demo.controller;

import com.example.demo.file_reader.FileReaderLocal;
import com.example.demo.mail_tools.Measure;
import com.example.demo.payload.UploadFileResponse;
import com.example.demo.service.FileStorageService;
import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);
    //ArrayList<List<String>> cs = null;
    String statements[];
    String complexity[];
	/* List<String> inner = new ArrayList<String>; */
    String cs;
    
    @Autowired
    private FileStorageService fileStorageService;
    
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String filePath = "E:\\Y0302\\SMP\\complexIt\\uploads\\";
 
        Measure measure = new Measure(filePath + fileName);
        
        cs = measure.start();
        //String json = new Gson().toJson(cs);
        return  cs;
    }

    @PostMapping("/uploadMultipleFiles")
    public List< String> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
