package Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import Application.Configs.Config;

@SpringBootApplication
public class Main {
    // Inicializa o WebClient para realizar as requests
    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder
                .baseUrl(Config.kitsuUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
