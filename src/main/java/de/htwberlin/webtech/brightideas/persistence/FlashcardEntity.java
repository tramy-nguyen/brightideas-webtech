package de.htwberlin.webtech.brightideas.persistence;

import javax.persistence.*;

@Entity(name = "flashcards")
public class FlashcardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "answer", nullable = false)
    private String answer;

    @Column(name = "category")
    private String category;

    public FlashcardEntity (String question, String answer, String category) {
        this.question = question;
        this.answer = answer;
        this.category = category;
    }

    protected FlashcardEntity() {}


    public long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
