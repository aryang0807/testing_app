package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.lang.Math;

public class Main {


    public static void main(String[] args) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();
        var client = HttpClient.newBuilder().build();

        int entries = 3;

        for (int entry = 0; entry < entries ; entry++) {
            String tempString = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ/_.";
            int length = (int) (Math.random() * 15 + 5);
            StringBuilder sb = new StringBuilder(length);
            for (int len = 0; len < length; len++) {
                int index = (int) (tempString.length() * Math.random());
                sb.append(tempString.charAt(index));
            }
            var url = "http://localhost:8080/urls/?testUrl="+sb.toString();
            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }
        long end = System.currentTimeMillis();
        System.out.print("Execution time is " +(end - start) + "milli seconds");
    }
}






