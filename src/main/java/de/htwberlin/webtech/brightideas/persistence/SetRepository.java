package de.htwberlin.webtech.brightideas.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetRepository  extends JpaRepository<SetEntity, Long> {
}

