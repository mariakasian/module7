package com.maria.cats;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.maria.cats.Utils.*;

public class HttpStatusChecker {
    public static String getStatusImage(int code) throws IOException {
        String imageUrl = START_URL + code + EXTENSION;
        HttpURLConnection connection = (HttpURLConnection) new URL(imageUrl).openConnection();
        connection.setRequestMethod("HEAD");
        int responseCode = connection.getResponseCode();

        if(responseCode == 404) {
            throw new FileNotFoundException(String.format(FILE_NOT_FOUND_EXCEPTION_TEXT, code));
        } else {
            return imageUrl;
        }
    }
}

