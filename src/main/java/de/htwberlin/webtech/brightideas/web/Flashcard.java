package de.htwberlin.webtech.brightideas.web;

public class Flashcard {

    private long id;
    private String question;
    private String answer;
    private String category;
    private Long setId;

    public Flashcard(long id, String question, String answer, String category, Long setId) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.category = category;
        this.setId = setId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Long getSetId() {
        return setId;
    }

    public void setSetId(Long setId) {
        this.setId = setId;
    }



}
