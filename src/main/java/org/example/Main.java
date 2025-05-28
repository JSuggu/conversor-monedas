package org.example;

import org.example.app.ConversorApp;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConversorApp conversorApp = new ConversorApp();
        conversorApp.init();
    }
}