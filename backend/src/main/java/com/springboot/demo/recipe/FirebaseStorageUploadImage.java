package com.springboot.demo.recipe;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class FirebaseStorageUploadImage {
    private final Logger log = LoggerFactory.getLogger(FirebaseStorageUploadImage.class);
    private final Environment environment;
    private StorageOptions storageOptions;
    private String bucketName;
    private String projectId;
    private String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/easiereconomy.appspot.com/o/%s?alt=media";

    public FirebaseStorageUploadImage(Environment environment) {
        this.environment = environment;
    }

    private String uploadFile(File file, String fileName) throws IOException {
        BlobId blobId = BlobId.of("easiereconomy.appspot.com", fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        Credentials credentials = GoogleCredentials.fromStream(new ClassPathResource("./serviceaccount.json").getInputStream());
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));
        return String.format(DOWNLOAD_URL, URLEncoder.encode(fileName, StandardCharsets.UTF_8));
    }

    private File convertToFile(MultipartFile multipartFile, String fileName) throws IOException {
        File tempFile = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartFile.getBytes());
            fos.close();
        }
        return tempFile;
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public String upload(MultipartFile multipartFile) {
        try {
            String fileName = multipartFile.getOriginalFilename();                        // to get original file name
            fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));  // to generated random string values for file name.

            File file = this.convertToFile(multipartFile, fileName);                      // to convert multipartFile to File
            String link = this.uploadFile(file, fileName);                                   // to get uploaded file link
            file.delete();                                                                // to delete the copy of uploaded file stored in the project folder
            return link;                     // Your customized response
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object download(String fileName) throws IOException {
        String destFileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));     // to set random strinh for destination file name
        String destFilePath = "Z:\\New folder\\" + destFileName;                                    // to set destination file path

        ////////////////////////////////   Download
        Credentials credentials = GoogleCredentials.fromStream(new ClassPathResource("./serviceaccount.json").getInputStream());
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        Blob blob = storage.get(BlobId.of("easiereconomy.appspot.com", fileName));
        URL signedUrl = blob.signUrl(100, TimeUnit.MINUTES);
        //System.out.println();
        String link = "https://firebasestorage.googleapis.com/v0/b"+signedUrl.getPath()+"?alt=media";
        System.out.println(link);
        //blob.downloadTo(Paths.get(destFilePath));
        return link;
    }
}
