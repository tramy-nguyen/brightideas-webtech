package de.htwberlin.webtech.brightideas.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "sets")
public class SetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "subject")
    @Enumerated(value = EnumType.STRING)
    private Subject subject;

    @OneToMany(mappedBy = "set", fetch = FetchType.EAGER)
    private List<FlashcardEntity> deck = new ArrayList<>();


    public SetEntity(String title, String description, Subject subject) {
        this.title = title;
        this.description = description;
        this.subject = subject;
    }

    public SetEntity() {}

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<FlashcardEntity> getDeck() {
        return deck;
    }

    public void setDeck(List<FlashcardEntity> deck) {
        this.deck = deck;
    }


}
