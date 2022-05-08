package de.htwberlin.webtech.brightideas.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FlashcardRestController {


    private List<Flashcard> flashcards;

    public FlashcardRestController(){
        this.flashcards = new ArrayList<>();
        flashcards.add(new Flashcard(1,"Was heißt Katze auf Englisch?", "cat", "dog; pig; cat; meow", false, "Englisch" ));
        flashcards.add(new Flashcard(2, "Welche Farbe hat der Himmel?", "blau", "blau; grün; lila; braun" ,false, "Kunst"));
    }

    @GetMapping(path = "/api/v1/flashcards")
    public ResponseEntity<List<Flashcard>> fetchFlashcards() {
        return ResponseEntity.ok(flashcards);
    }
}
