package org.example;

import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public final static int PORT = 8989;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            JSONObject jsonTask = new JSONObject();
            jsonTask.put("task", "Сходить в магазин");
            jsonTask.put("type", "ADD");
            System.out.println(jsonTask);
            System.out.println(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

