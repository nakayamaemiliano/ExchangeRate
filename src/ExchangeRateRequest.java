import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class ExchangeRateRequest {
    public static void main(String[] args) {
        HttpClient cliente = HttpClient.newHttpClient();

        String apiKey = "c22b3607c8e58a706d09875d";
        String url= "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        System.out.println("Solicitud HTTP configurada correctamente : " + solicitud);
    }

}
