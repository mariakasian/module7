package com.maria.cats;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.maria.cats.HttpImageStatusCli.askStatus;

class HttpImageStatusCliTest {

    @Test
    void testThatAskStatusWithValidInputReturnsExpectedOutput() throws IOException {
        String input = "200" + System.lineSeparator() + "exit" + System.lineSeparator();
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        askStatus();

        String expectedOutput = "Enter HTTP status code (or 'exit' to exit): " + System.lineSeparator() +
                "You will find the Cat in the 'images' directory!" + System.lineSeparator() +
                "Enter HTTP status code (or 'exit' to exit): " + System.lineSeparator();

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testThatAskStatusWithInvalidInputPrintsErrorMessage() throws IOException {
        String input = "invalid" + System.lineSeparator() + "exit" + System.lineSeparator();
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        askStatus();

        String expectedOutput = "Enter HTTP status code (or 'exit' to exit): " + System.lineSeparator() +
                "Please enter valid code!" + System.lineSeparator() +
                "Enter HTTP status code (or 'exit' to exit): " + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }
}
