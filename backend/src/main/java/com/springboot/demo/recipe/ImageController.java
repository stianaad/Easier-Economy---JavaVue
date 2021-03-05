package com.springboot.demo.recipe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200", "http://localhost:8081"})
@RestController
public class ImageController {
    private final Logger logger = LoggerFactory.getLogger(FirebaseStorageUploadImage.class);
    @Autowired
    FirebaseStorageUploadImage firebaseStorageUploadImage;
    @PostMapping("/profile/pic")
    public String upload(@RequestParam("file") MultipartFile multipartFile) {
        return firebaseStorageUploadImage.upload(multipartFile);
    }

    @PostMapping("/profile/pic/{fileName}")
    public Object download(@PathVariable String fileName) throws IOException {
        return firebaseStorageUploadImage.download(fileName);
    }
}
