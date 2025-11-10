import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateResponse {
    public static void main(String[] args) {
        HttpClient cliente = HttpClient.newHttpClient();

        String apiKey = "c22b3607c8e58a706d09875d";
        String url= "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {

            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

            System.out.println("Código de estado: " + respuesta.statusCode());
            System.out.println("Respuesta JSON:");
            System.out.println(respuesta.body());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
