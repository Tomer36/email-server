package com.emailserver.client;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class EmailClient {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer email (To): ");
        String to = scanner.nextLine();

        System.out.print("Enter your email (From, e.g. tamer@gmail.com): ");
        String from = scanner.nextLine();

        System.out.print("Enter message body: ");
        String body = scanner.nextLine();

        String jsonInputString = String.format("""
                {
                  "to": "%s",
                  "from": "%s",
                  "body": "%s"
                }
                """, to, from, body);

        URL url = new URL("http://localhost:8080/email/send");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setRequestProperty("Content-Type", "application/json");

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int code = con.getResponseCode();
        System.out.println("Response Code: " + code);
    }
}
