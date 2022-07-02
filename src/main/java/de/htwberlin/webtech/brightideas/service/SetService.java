package de.htwberlin.webtech.brightideas.service;

import de.htwberlin.webtech.brightideas.persistence.SetEntity;
import de.htwberlin.webtech.brightideas.persistence.SetRepository;
import de.htwberlin.webtech.brightideas.persistence.Subject;
import de.htwberlin.webtech.brightideas.web.Set;
import de.htwberlin.webtech.brightideas.web.SetManipulationRequest;

import java.util.List;
import java.util.stream.Collectors;


public class SetService {

    private final SetRepository setRepository;

    private final SetTransformer setTransformer;

    public SetService(SetRepository setRepository, SetTransformer setTransformer) {
        this.setRepository = setRepository;
        this.setTransformer = setTransformer;
    }


    public List<Set> findAll() {
        List<SetEntity> sets = setRepository.findAll();
        return sets.stream()
                .map(setTransformer:: transformEntity)
                .collect(Collectors.toList());
    }

    public Set findById(Long id) {
        var setEntity = setRepository.findById(id);
        return setEntity.isPresent()? setTransformer.transformEntity(setEntity.get()) : null;
    }

    // Problem bei Flashcard zu FlashcardEntity
    public Set create(SetManipulationRequest request) {
        var subject = Subject.valueOf(request.getSubject());
        var setEntity = new SetEntity(request.getTitle(), request.getDescription(), subject);
        setEntity = setRepository.save(setEntity);
        return setTransformer.transformEntity(setEntity);
    }

    public Set update(Long id, SetManipulationRequest request) {
        var setEntityOptional = setRepository.findById(id);


        // Problem Übergabe von Flashcard zu Entity und String zu Subject
        var setEntity = setEntityOptional.get();
        setEntity.setTitle(request.getTitle());
        setEntity.setDescription(request.getDescription());
        setEntity.setSubject(Subject.valueOf(request.getSubject()));
        setEntity = setRepository.save(setEntity);

        return setTransformer.transformEntity(setEntity);
    }
    public boolean deleteById(Long id) {
        if(!setRepository.existsById(id)) {
            return false;
        }
        setRepository.deleteById(id);
        return true;
    }

}
