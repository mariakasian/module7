package com.maria.cats;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.maria.cats.HttpStatusChecker.getStatusImage;
import static com.maria.cats.Utils.EXTENSION;
import static com.maria.cats.Utils.START_URL;

class HttpStatusCheckerTest {

    @Test
    void testThatGetStatusImageUrlCorrectly() throws IOException {
        int code = 204;
        String imageUrl = START_URL + code + EXTENSION;
        Assertions.assertEquals(imageUrl, getStatusImage(code));
    }

    @Test
    void testThatInvalidCodeThrowsException() {
        Assertions.assertThrows(FileNotFoundException.class, () -> getStatusImage(1000));
    }
}