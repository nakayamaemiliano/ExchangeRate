import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateFilter {
    public static void main(String[] args) {
        String apiKey = "c22b3607c8e58a706d09875d";
        String url= "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

            if (respuesta.statusCode() == 200) {
                JsonObject json = JsonParser.parseString(respuesta.body()).getAsJsonObject();
                JsonObject conversionRates = json.getAsJsonObject("conversion_rates");

                // Filtramos las monedas deseadas por "Currency Code"
                double ars = conversionRates.get("ARS").getAsDouble();
                double brl = conversionRates.get("BRL").getAsDouble();
                double eur = conversionRates.get("EUR").getAsDouble();

                System.out.println("=== Tasas de conversión filtradas ===");
                System.out.println("USD a ARS: " + ars);
                System.out.println("USD a BRL: " + brl);
                System.out.println("USD a EUR: " + eur);

            } else {
                System.out.println("Error HTTP: " + respuesta.statusCode());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
