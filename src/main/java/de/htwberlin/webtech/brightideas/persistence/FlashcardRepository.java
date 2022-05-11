package de.htwberlin.webtech.brightideas.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlashcardRepository extends JpaRepository<FlashcardEntity,Long> {

    List<FlashcardEntity> findAllByQuestion(String question);
}
