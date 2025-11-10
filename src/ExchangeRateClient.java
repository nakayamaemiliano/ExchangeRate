import java.net.http.HttpClient;

public class ExchangeRateClient {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newHttpClient();

        System.out.println("Cliente HTTP creado exitosamente :)  : " + httpClient);
    }
}
