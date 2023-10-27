package com.maria.cats;

import java.io.*;
import java.net.URL;

import static com.maria.cats.HttpStatusChecker.getStatusImage;
import static com.maria.cats.Utils.*;

public class HttpStatusImageDownloader {
    public static void downloadStatusImage(int code) throws IOException {
        String imageUrl = getStatusImage(code);
        String pathToSave = DIRECTORY_FOR_SAVE + code + EXTENSION;

        try (InputStream in = new URL(imageUrl).openStream();
             FileOutputStream out = new FileOutputStream(pathToSave)) {

            System.out.println("You will find the Cat in the 'images' directory!");
            byte[] buffer = new byte[1024*20];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}
