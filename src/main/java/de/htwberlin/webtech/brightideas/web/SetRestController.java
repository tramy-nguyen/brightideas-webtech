package de.htwberlin.webtech.brightideas.web;

import de.htwberlin.webtech.brightideas.service.SetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class SetRestController {

    private final SetService setService;

    public SetRestController(SetService setService) {this.setService = setService;}

    @GetMapping(path = "/api/v1/sets")
    public ResponseEntity<List<Set>> fetchSets() { return ResponseEntity.ok(setService.findAll()); }

    @GetMapping(path = "/api/v1/sets/{id}")
    public ResponseEntity<Set> fetchSetById(@PathVariable Long id) {
        var set = setService.findById(id);
        return set != null? ResponseEntity.ok(set) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/sets")
    public ResponseEntity<Void> createSet(@RequestBody SetManipulationRequest request) throws URISyntaxException {
        var set = setService.create(request);
        URI uri = new URI("/api/v1/sets/" + set.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path ="/api/v1/sets/{id}")
    public ResponseEntity<Set>updateSet(@PathVariable Long id, @RequestBody SetManipulationRequest request){
        var set =  setService.update(id, request);
        return set != null? ResponseEntity.ok(set): ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/sets/{id}")
    public ResponseEntity<Void> deleteSet(@PathVariable Long id) {
        boolean deleted = setService.deleteById(id);
        return deleted? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}

