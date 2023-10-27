package com.maria.cats;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.maria.cats.HttpStatusImageDownloader.downloadStatusImage;
import static org.junit.jupiter.api.Assertions.*;

class HttpStatusImageDownloaderTest {
    @Test
    void testThatValidDownloadStatusImageCorrectly() throws IOException {
        int code = 200;

        downloadStatusImage(code);

        //Перевіряємо, чи зображення було збережено в папці "images".
        File expectedFile = new File("images/200.jpg");
        assertTrue(expectedFile.exists());
        assertTrue(expectedFile.isFile());
    }

    @Test
    void testThatInvalidDownloadStatusImageThrowsException() {
        assertThrows(IOException.class, () -> downloadStatusImage(10000));
    }
}
