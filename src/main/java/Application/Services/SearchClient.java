package Application.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import Application.Controllers.BuildResponse;
import Application.Controllers.BuildResponseList;
import reactor.core.publisher.Mono;

@Service
public class SearchClient {

    @Autowired
    private WebClient webClient;

    /**
     * Retorna todos os animes ou mangás
     */
    public BuildResponseList getAll(String type) {

        Mono<BuildResponseList> monoData = this.webClient
                .method(HttpMethod.GET)
                .uri("/{type}", type)
                .retrieve()
                .bodyToMono(BuildResponseList.class);

        BuildResponseList data = monoData.block();

        return data;
    }

    /**
     * Retorna um anime ou mangá específico
     */
    public BuildResponse getById(String type, Integer id) {

        Mono<BuildResponse> monoData = this.webClient
                .method(HttpMethod.GET)
                .uri("/{type}/{id}", type, id)
                .retrieve()
                .bodyToMono(BuildResponse.class);

        BuildResponse data = monoData.block();

        return data;
    }

    /**
     * Retorna os animes ou mangás mais populares
     */
    public BuildResponseList getTrending(String type) {

        Mono<BuildResponseList> monoData = this.webClient
                .method(HttpMethod.GET)
                .uri("/trending/{type}", type)
                .retrieve()
                .bodyToMono(BuildResponseList.class);

        BuildResponseList data = monoData.block();

        return data;
    }

    /**
     * Retorna os animes ou mangás com a utilização de filtros
     */
    public BuildResponseList getFilter(String type, String filtering, String slug) {

        Mono<BuildResponseList> monoData = this.webClient
                .method(HttpMethod.GET)
                .uri("/{type}?filter[{filtering}]={slug}", type, filtering, slug)
                .retrieve()
                .bodyToMono(BuildResponseList.class);

        BuildResponseList data = monoData.block();

        return data;
    }

    /**
     * Retorna os episódios de um anime
     */
    public BuildResponseList getEpisodeByAnimeId(Integer id) {

        Mono<BuildResponseList> monoData = this.webClient
                .method(HttpMethod.GET)
                .uri("/anime/{id}/episodes", id)
                .retrieve()
                .bodyToMono(BuildResponseList.class);

        BuildResponseList data = monoData.block();

        return data;
    }

    /**
     * Retorna os episódios de um mangá
     */
    public BuildResponseList getChapterByMangaId(Integer id) {

        Mono<BuildResponseList> monoData = this.webClient
                .method(HttpMethod.GET)
                .uri("/manga/{id}/chapters", id)
                .retrieve()
                .bodyToMono(BuildResponseList.class);

        BuildResponseList data = monoData.block();

        return data;
    }
}