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

    @Column(name = "options")
    private String options;

    @Column(name = "flip", nullable = false)
    private boolean flip;

    @Column(name = "category")
    private String category;

    public FlashcardEntity (long id, String question, String answer, String options, boolean flip, String category) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.options = options;
        this.flip = flip;
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

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public boolean isFlip() {
        return flip;
    }

    public void setFlip(boolean flip) {
        this.flip = flip;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
