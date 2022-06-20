package de.htwberlin.webtech.brightideas.web;

import de.htwberlin.webtech.brightideas.service.FlashcardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class FlashcardRestController {


    private final FlashcardService flashcardService;

    public FlashcardRestController( FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }


    @GetMapping(path = "/api/v1/flashcards")
    public ResponseEntity<List<Flashcard>> fetchFlashcards() {
        return ResponseEntity.ok(flashcardService.findAll());
    }

    @GetMapping(path = "/api/v1/flashcards/{id}")
    public ResponseEntity<Flashcard> fetchFlashcardById(@PathVariable Long id) {
        var flashcard = flashcardService.findById(id);

        return flashcard != null? ResponseEntity.ok(flashcard) : ResponseEntity.notFound().build();
    }


    @PostMapping(path = "/api/v1/flashcards")
    public ResponseEntity<Void> createFlashcard(@RequestBody FlashcardManipulationRequest request) throws URISyntaxException {
        var flashcard= flashcardService.create(request);
        URI uri = new URI("/api/v1/flashcards/" + flashcard.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/flashcards/{id}")
    public ResponseEntity<Flashcard> updateFlashcard(@PathVariable Long id, @RequestBody FlashcardManipulationRequest request){
        var flashcard = flashcardService.update(id, request);
        return flashcard != null? ResponseEntity.ok(flashcard) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/flashcards/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        boolean deleted = flashcardService.deleteById(id);
        return deleted? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }



    /**
     public FlashcardRestController(){
     this.flashcards = new ArrayList<>();
     flashcards.add(new Flashcard(1,"Was heißt Katze auf Englisch?", "cat", "dog; pig; cat; meow", false, "Englisch" ));
     flashcards.add(new Flashcard(2, "Welche Farbe hat der Himmel?", "blau", "blau; grün; lila; braun" ,false, "Kunst"));
     }
     */
}
