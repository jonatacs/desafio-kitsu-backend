package Application.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Application.Connection.Searches;
import Application.Connection.SearchesRepository;
import Application.Services.SearchClient;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController    
@ApiOperation(value = "Rotas")
@RequestMapping("/v1")
public class PathMaps {
    @Autowired
    private SearchClient searchClient;
    @Autowired
    private SearchesRepository searchesRepository;

    @ApiOperation(value = "Caminho utilizado para retornar as buscas realizadas.")
    @GetMapping(path = "/searches")
    public @ResponseBody Iterable<Searches> getAllSearches() {
        return searchesRepository.findAll();
    }
    
    @ApiOperation(value = "Caminho utilizado para retornar as buscas mais comuns.")
    @GetMapping(path = "/commonSearches")
    public @ResponseBody Iterable<Searches> getCommonSearches() {
        return searchesRepository.getCommon();
    }
    
    @ApiOperation(value = "Caminho utilizado para retornar todos os animes ou mangás")
    @ApiImplicitParam(name = "type", value = "Tipo que será buscado. Pode ser utilizado os tipos \"anime\" ou \"manga\".", required = true, dataType = "string")
    @GetMapping(value = "/{type}")
    public ResponseEntity<BuildResponseList> filterAll(@PathVariable String type) {
        BuildResponseList filter = this.searchClient.getAll(type);

        Integer count = 1;

        Searches search = searchesRepository.getSearch(type, "", "");
        if ( !ObjectUtils.isEmpty(search) ) {
            count = search.getCount() + 1;
        } else {
            search = new Searches();
            search.setType(type);
            search.setAction("");
            search.setSlug("");
        }
        search.setCount(count);
        searchesRepository.save(search);

        return ResponseEntity.ok(filter);
    }
    
    @ApiOperation(value = "Caminho utilizado para retornar um anime ou manga específico")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "type", value = "Tipo que será buscado. Pode ser utilizado os tipos \"anime\" ou \"manga\".", required = true, dataType = "string"),
        @ApiImplicitParam(name = "id", value = "ID do anime/manga que será buscado na base de dados da Kitsu API.", required = true, dataType = "integer")
    })
    @GetMapping(value = "/{type}/{id}")
    public ResponseEntity<BuildResponse> filterById(@PathVariable String type, @PathVariable Integer id) {
        BuildResponse filter = this.searchClient.getById(type, id);

        Integer count = 1;

        Searches search = searchesRepository.getSearch(type, String.valueOf(id), "");
        if ( !ObjectUtils.isEmpty(search) ) {
            count = search.getCount() + 1;
        } else {
            search = new Searches();
            search.setType(type);
            search.setAction(String.valueOf(id));
            search.setSlug("");
        }
        search.setCount(count);
        searchesRepository.save(search);

        return ResponseEntity.ok(filter);
    }
    
    @ApiOperation(value = "Caminho utilizado para retornar os animes ou mangás mais populares")
    @ApiImplicitParam(name = "type", value = "Tipo que será buscado. Pode ser utilizado os tipos \"anime\" ou \"manga\".", required = true, dataType = "string")
    @GetMapping(value = "/{type}/trending")
    public ResponseEntity<BuildResponseList> filterTrending(@PathVariable String type) {
        BuildResponseList filter = this.searchClient.getTrending(type);

        Integer count = 1;

        Searches search = searchesRepository.getSearch(type, "trending", "");
        if ( !ObjectUtils.isEmpty(search) ) {
            count = search.getCount() + 1;
        } else {
            search = new Searches();
            search.setType(type);
            search.setAction("trending");
            search.setSlug("");
        }
        search.setCount(count);
        searchesRepository.save(search);

        return ResponseEntity.ok(filter);
    }
    
    @ApiOperation(value = "Caminho utilizado para retornar os animes ou mangás com a utilização de filtros")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "type", value = "Tipo que será buscado. Pode ser utilizado os tipos \"anime\" ou \"manga\".", required = true, dataType = "string"),
        @ApiImplicitParam(name = "filtering", value = "Tipo de filtro que será utilizado na busca. Poderá ser utilizados os tipos \"categories\", \"text\", \"slug\", \"season\", \"seasonYear\", \"streamers\", \"ageRating\".", required = true, dataType = "string"),
        @ApiImplicitParam(name = "slug", value = "Filtro que será utilizado na busca.", required = true, dataType = "string")
    })
    @GetMapping(value = "/{type}/{filtering}/{slug}")
    public ResponseEntity<BuildResponseList> filterSettings(@PathVariable String type, @PathVariable String filtering, @PathVariable String slug) {
        BuildResponseList filter = this.searchClient.getFilter(type, filtering, slug);

        Integer count = 1;

        Searches search = searchesRepository.getSearch(type, filtering, slug);
        if ( !ObjectUtils.isEmpty(search) ) {
            count = search.getCount() + 1;
        } else {
            search = new Searches();
            search.setType(type);
            search.setAction(filtering);
            search.setSlug(slug);
        }
        search.setCount(count);
        searchesRepository.save(search);

        return ResponseEntity.ok(filter);
    }
    
    @ApiOperation(value = "Caminho utilizado para retornar os episódios de um anime")
    @ApiImplicitParam(name = "id", value = "ID do episódio que será buscado na base de dados da Kitsu API.", required = true, dataType = "integer")
    @GetMapping(value = "/anime/{id}/episodes")
    public ResponseEntity<BuildResponseList> filterEpisodeByAnimeId(@PathVariable Integer id) {
        BuildResponseList filter = this.searchClient.getEpisodeByAnimeId(id);

        Integer count = 1;

        Searches search = searchesRepository.getSearch("anime", String.valueOf(id), "episodes");
        if ( !ObjectUtils.isEmpty(search) ) {
            count = search.getCount() + 1;
        } else {
            search = new Searches();
            search.setType("anime");
            search.setAction(String.valueOf(id));
            search.setSlug("episodes");
        }
        search.setCount(count);
        searchesRepository.save(search);

        return ResponseEntity.ok(filter);
    }
    
    @ApiOperation(value = "Caminho utilizado para retornar os capítulos de um mangá")
    @ApiImplicitParam(name = "id", value = "ID do capítulo que será buscado na base de dados da Kitsu API.", required = true, dataType = "integer")
    @GetMapping(value = "/manga/{id}/chapters")
    public ResponseEntity<BuildResponseList> filterChapterByMangaId(@PathVariable Integer id) {
        BuildResponseList filter = this.searchClient.getChapterByMangaId(id);

        Integer count = 1;

        Searches search = searchesRepository.getSearch("manga", String.valueOf(id), "chapters");
        if ( !ObjectUtils.isEmpty(search) ) {
            count = search.getCount() + 1;
        } else {
            search = new Searches();
            search.setType("manga");
            search.setAction(String.valueOf(id));
            search.setSlug("chapters");
        }
        search.setCount(count);
        searchesRepository.save(search);

        return ResponseEntity.ok(filter);
    }
}