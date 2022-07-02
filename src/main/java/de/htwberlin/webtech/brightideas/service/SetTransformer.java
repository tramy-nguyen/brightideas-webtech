package de.htwberlin.webtech.brightideas.service;

import de.htwberlin.webtech.brightideas.persistence.FlashcardEntity;
import de.htwberlin.webtech.brightideas.persistence.SetEntity;
import de.htwberlin.webtech.brightideas.web.Flashcard;
import de.htwberlin.webtech.brightideas.web.Set;

import java.util.ArrayList;
import java.util.List;

public class SetTransformer {

    public Set transformEntity(SetEntity setEntity){

        var subject = setEntity.getSubject().name();



        return new Set(
                setEntity.getId(),
                setEntity.getTitle(),
                setEntity.getDescription(),
                subject
        );
    }
}
