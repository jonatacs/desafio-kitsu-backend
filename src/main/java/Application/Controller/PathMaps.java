package Application.Controller;

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

    @GetMapping(value = "")
    public String initSystem() {
        return Config.kitsuUrl;
    }

    @GetMapping(value = "/{type}")
    public ResponseEntity<BuildResponseList> filterAll(@PathVariable String type) {
        BuildResponseList filter = this.searchClient.getAll(type);

        return ResponseEntity.ok(filter);
    }

    @GetMapping(value = "/{type}/{id}")
    public ResponseEntity<BuildResponse> filterById(@PathVariable String type, @PathVariable Integer id) {
        BuildResponse filter = this.searchClient.getById(type, id);

        return ResponseEntity.ok(filter);
    }

    @GetMapping(value = "/{type}/trending")
    public ResponseEntity<BuildResponseList> filterTrending(@PathVariable String type) {
        BuildResponseList filter = this.searchClient.getTrending(type);

        return ResponseEntity.ok(filter);
    }

    @GetMapping(value = "/{type}/{filtering}/{slug}")
    public ResponseEntity<BuildResponseList> filterSettings(@PathVariable String type, @PathVariable String filtering, @PathVariable String slug) {
        BuildResponseList filter = this.searchClient.getFilter(type, filtering, slug);

        return ResponseEntity.ok(filter);
    }
}