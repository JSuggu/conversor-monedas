package org.example.app;

import com.google.gson.Gson;
import org.example.app.model.ExchangeResult;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorApp {
    private final String baseUrl = "https://v6.exchangerate-api.com/v6/010f129f2b41294334bc564a/pair";
    private final HttpClient client = HttpClient.newHttpClient();
    private HttpRequest request;

    public void init() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        System.out.println("""
            Bienvenido al conversor de monedas:
            1) Peso argenino => Dolar
            2) Dolar => Peso argenino
            3) Peso Argentino => Real brasileño
            4) Real brasileño => Peso Argentino
            5) Euro => Peso Argentino
            6) Peso Argenino => Euro
            7) Conversion Par a Par (Ingrese los codigos de las monedas. Ejemplo: USD y luego EUR)
            8) Salir
        """);

        while (flag){

            System.out.print("Opcion: ");
            int option = sc.nextInt();
            sc.nextLine();

            if(option >= 8 || option < 1){
                flag = false;
                continue;
            }

            if(option <=6){
                System.out.print("Seleccione la cantidad: ");
                Double amount = sc.nextDouble();
                sc.nextLine();
                Double total = chosenOperation(option, amount);
                System.out.println("Total: " + total + "\n");
                continue;
            }

            System.out.print("Ingrese el codigo de la primera moneda: ");
            String from = sc.nextLine();

            System.out.print("Ingrese el codigo de la segunda moneda: ");
            String to = sc.nextLine();

            System.out.print("Seleccione la cantidad: ");
            Double amount = sc.nextDouble();

            Double total = calculateConversion(amount, from, to);
            System.out.println("Total: " + total + "\n");

        }
        sc.close();
    }

    private Double loadConversionRate(String pair) throws IOException, InterruptedException {
        request = HttpRequest.newBuilder().uri(URI.create(baseUrl + pair)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        ExchangeResult result = gson.fromJson(response.body(), ExchangeResult.class);
        return result.getConversionRate();
    }

    private Double chosenOperation(Integer option, Double amount) throws IOException, InterruptedException {
        return switch (option) {
            case 1 -> calculateConversion(amount, "ARS", "USD");
            case 2 -> calculateConversion(amount, "USD", "ARS");
            case 3 -> calculateConversion(amount, "ARS", "BRL");
            case 4 -> calculateConversion(amount, "BRL", "ARS");
            case 5 -> calculateConversion(amount, "ARS", "EUR");
            case 6 -> calculateConversion(amount, "EUR", "ARS");
            default -> null;
        };
    }

    private Double calculateConversion(Double amount, String from, String to) throws IOException, InterruptedException {
        Double conversionRate = loadConversionRate("/"+from+"/"+to);
        if (conversionRate == null) {
            System.out.println("No se encontro el ratio de conversion entre las monedas");
            return null;
        };
        return amount * conversionRate;
    }


}
