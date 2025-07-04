package com.emailserver.client;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class EmailClientMultithreaded {

    public static void main(String[] args) {
        int threadCount = 10; // Number of concurrent emails to send
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            final int idx = i;
            threads[i] = new Thread(() -> {
                String to = "tamer8@live.com";
                String from;
                if (idx % 3 == 0) {
                    from = "testuser@gmail.com";
                } else if (idx % 3 == 1) {
                    from = "testuser@walla.co.il";
                } else {
                    from = "testuser@yahoo.com";
                }
                String body = "Multithreaded test email #" + idx + " from " + from;
                sendEmail(to, from, body);
            }, "Test-Thread-" + i);
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException ignored) {}
        }

        System.out.println("All multithreaded requests sent!");
    }

    private static void sendEmail(String to, String from, String body) {
        try {
            URL url = new URL("http://localhost:8080/email/send");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json");

            String jsonInputString = String.format("""
                    {
                      "to": "%s",
                      "from": "%s",
                      "body": "%s"
                    }
                    """, to, from, body);

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int code = con.getResponseCode();
            System.out.printf("[%s] Sent from %s to %s | Response Code: %d%n",
                    Thread.currentThread().getName(), from, to, code);
        } catch (Exception e) {
            System.err.printf("[%s] Failed to send email: %s%n",
                    Thread.currentThread().getName(), e.getMessage());
        }
    }
}
