import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorMonedas {
    private static final String API_KEY = "TU_API_KEY";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HttpClient cliente = HttpClient.newHttpClient();

        try {
            // Conectamos con la API
            String url = BASE_URL + API_KEY + "/latest/USD";
            HttpRequest solicitud = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

            if (respuesta.statusCode() == 200) {
                JsonObject json = JsonParser.parseString(respuesta.body()).getAsJsonObject();
                JsonObject rates = json.getAsJsonObject("conversion_rates");

                double ars = rates.get("ARS").getAsDouble();
                double brl = rates.get("BRL").getAsDouble();
                double eur = rates.get("EUR").getAsDouble();

                boolean continuar = true;

                while (continuar) {
                    System.out.println("\n=== Conversor de Monedas ===");
                    System.out.println("1. USD → ARS");
                    System.out.println("2. ARS → USD");
                    System.out.println("3. USD → BRL");
                    System.out.println("4. BRL → USD");
                    System.out.println("5. USD → EUR");
                    System.out.println("6. EUR → USD");
                    System.out.println("0. Salir");
                    System.out.print("Seleccione una opción: ");

                    int opcion = sc.nextInt();

                    if (opcion == 0) {
                        continuar = false;
                        System.out.println("Programa finalizado.");
                        break;
                    }

                    System.out.print("Monto a convertir: ");
                    double monto = sc.nextDouble();

                    double resultado = convertirMoneda(opcion, monto, ars, brl, eur);
                    System.out.println("Resultado: " + resultado);
                }

            } else {
                System.out.println("Error HTTP: " + respuesta.statusCode());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

    private static double convertirMoneda(int opcion, double monto, double ars, double brl, double eur) {
        switch (opcion) {
            case 1: return monto * ars;   // USD → ARS
            case 2: return monto / ars;   // ARS → USD
            case 3: return monto * brl;   // USD → BRL
            case 4: return monto / brl;   // BRL → USD
            case 5: return monto * eur;   // USD → EUR
            case 6: return monto / eur;   // EUR → USD
            default:
                System.out.println("Opción inválida.");
                return 0;
        }
    }
}
