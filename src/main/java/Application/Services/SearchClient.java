package Application.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import Application.Controller.BuildResponse;
import Application.Controller.BuildResponseList;
import reactor.core.publisher.Mono;

@Service
public class SearchClient {

    @Autowired
    private WebClient webClient;

    public BuildResponseList getAll(String type) {

        Mono<BuildResponseList> monoData = this.webClient
                .method(HttpMethod.GET)
                .uri("/{type}", type)
                .retrieve()
                .bodyToMono(BuildResponseList.class);

        BuildResponseList data = monoData.block();

        return data;
    }

    public BuildResponse getById(String type, Integer id) {

        Mono<BuildResponse> monoData = this.webClient
                .method(HttpMethod.GET)
                .uri("/{type}/{id}", type, id)
                .retrieve()
                .bodyToMono(BuildResponse.class);

        BuildResponse data = monoData.block();

        return data;
    }

    public BuildResponseList getTrending(String type) {

        Mono<BuildResponseList> monoData = this.webClient
                .method(HttpMethod.GET)
                .uri("/trending/{type}", type)
                .retrieve()
                .bodyToMono(BuildResponseList.class);

        BuildResponseList data = monoData.block();

        return data;
    }
}