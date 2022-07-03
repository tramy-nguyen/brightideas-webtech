package de.htwberlin.webtech.brightideas.service;

import de.htwberlin.webtech.brightideas.persistence.FlashcardEntity;
import de.htwberlin.webtech.brightideas.persistence.SetEntity;
import de.htwberlin.webtech.brightideas.web.Flashcard;
import de.htwberlin.webtech.brightideas.web.Set;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SetTransformer {

    public Set transformEntity(SetEntity setEntity){

        var subject = setEntity.getSubject().name();

        List<Flashcard> flashcardsL = new ArrayList<>();

        for(FlashcardEntity entity : setEntity.getDeck()) {
            Flashcard a = new Flashcard(entity.getId(), entity.getQuestion(), entity.getAnswer(), entity.getCategory(), setEntity.getId());
            flashcardsL.add(a);
        }

        return new Set(
                setEntity.getId(),
                setEntity.getTitle(),
                setEntity.getDescription(),
                subject,
                flashcardsL
        );
    }
}
