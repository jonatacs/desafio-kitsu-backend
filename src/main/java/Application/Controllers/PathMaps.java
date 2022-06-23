package Application.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import Application.Services.SearchClient;
import Application.Configs.Config;

@RestController
public class PathMaps {
    @Autowired
    private SearchClient searchClient;

    /**
     * Mapeia todos os caminhos utilizados para retorno de dados
     */

    /**
     * Caminho padrão
     */
    @GetMapping(value = "")
    public String initSystem() {
        return Config.defaultBody;
    }

    /**
     * Caminho utilizado para retornar todos os animes ou mangás
     * 
     * @param String type = Tipo de retorno esperado ( anime / mangá )
     */
    @GetMapping(value = "/{type}")
    public ResponseEntity<BuildResponseList> filterAll(@PathVariable String type) {
        BuildResponseList filter = this.searchClient.getAll(type);

        return ResponseEntity.ok(filter);
    }

    /**
     * Caminho utilizado para retornar um anime ou manga específico
     * 
     * @param String type   = Tipo de retorno esperado ( anime / mangá )
     * @param Integer id    = ID do anime/mangá
     */
    @GetMapping(value = "/{type}/{id}")
    public ResponseEntity<BuildResponse> filterById(@PathVariable String type, @PathVariable Integer id) {
        BuildResponse filter = this.searchClient.getById(type, id);

        return ResponseEntity.ok(filter);
    }

    /**
     * Caminho utilizado para retornar os animes ou mangás mais populares
     * 
     * @param String type   = Tipo de retorno esperado ( anime / mangá )
     */
    @GetMapping(value = "/{type}/trending")
    public ResponseEntity<BuildResponseList> filterTrending(@PathVariable String type) {
        BuildResponseList filter = this.searchClient.getTrending(type);

        return ResponseEntity.ok(filter);
    }

    /**
     * Caminho utilizado para retornar os animes ou mangás com a utilização de filtros
     * 
     * @param String type       = Tipo de retorno esperado ( anime / mangá )
     * @param String filtering  = Tipo de filtro ( categories / text)
     * @param String slug       = Filtro a ser utilizado
     */
    @GetMapping(value = "/{type}/{filtering}/{slug}")
    public ResponseEntity<BuildResponseList> filterSettings(@PathVariable String type, @PathVariable String filtering, @PathVariable String slug) {
        BuildResponseList filter = this.searchClient.getFilter(type, filtering, slug);

        return ResponseEntity.ok(filter);
    }

    /**
     * Caminho utilizado para retornar os episódios de um anime
     * 
     * @param Integer id    = ID do anime
     */
    @GetMapping(value = "/anime/{id}/episodes")
    public ResponseEntity<BuildResponseList> filterEpisodeByAnimeId(@PathVariable Integer id) {
        BuildResponseList filter = this.searchClient.getEpisodeByAnimeId(id);

        return ResponseEntity.ok(filter);
    }

    /**
     * Caminho utilizado para retornar os capítulos de um mangá
     * 
     * @param Integer id    = ID do mangá
     */
    @GetMapping(value = "/manga/{id}/chapters")
    public ResponseEntity<BuildResponseList> filterChapterByMangaId(@PathVariable Integer id) {
        BuildResponseList filter = this.searchClient.getChapterByMangaId(id);

        return ResponseEntity.ok(filter);
    }
}