package de.htwberlin.webtech.brightideas.web;

public class FlashcardManipulationRequest {

    private String question;
    private String answer;
    private String category;

    public FlashcardManipulationRequest(String question, String answer, String category) {
        this.question = question;
        this.answer = answer;
        this.category = category;
    }

    public FlashcardManipulationRequest() {}

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
