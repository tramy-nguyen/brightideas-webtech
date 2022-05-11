package de.htwberlin.webtech.brightideas.service;

import de.htwberlin.webtech.brightideas.persistence.FlashcardEntity;
import de.htwberlin.webtech.brightideas.persistence.FlashcardRepository;
import de.htwberlin.webtech.brightideas.web.Flashcard;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlashcardService {

    private final FlashcardRepository flashcardRepository;

    public FlashcardService(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository ;
    }

    public List<Flashcard> findAll() {
       List<FlashcardEntity> flashcards = flashcardRepository.findAll();
       return flashcards.stream()
               .map(FlashcardEntity -> new Flashcard(
                       FlashcardEntity.getId(),
                       FlashcardEntity.getQuestion(),
                       FlashcardEntity.getAnswer(),
                       FlashcardEntity.getOptions(),
                       FlashcardEntity.isFlip(),
                       FlashcardEntity.getCategory()

               ))
               .collect(Collectors.toList());
    }

}
