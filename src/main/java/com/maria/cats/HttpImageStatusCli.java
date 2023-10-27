package com.maria.cats;

import java.io.IOException;
import java.util.Scanner;

import static com.maria.cats.HttpStatusImageDownloader.downloadStatusImage;

public class HttpImageStatusCli {
    public static void askStatus() throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter HTTP status code (or 'exit' to exit): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                int code = Integer.parseInt(input);
                downloadStatusImage(code);
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid code!");
            }
        }
        scanner.close();
    }
}
