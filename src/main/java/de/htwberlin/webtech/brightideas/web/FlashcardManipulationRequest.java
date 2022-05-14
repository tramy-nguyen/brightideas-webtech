package de.htwberlin.webtech.brightideas.web;

public class FlashcardManipulationRequest {

    private String question;
    private String answer;
    private String options;
    private boolean flip;
    private String category;

    public FlashcardManipulationRequest(String question, String answer, String options, boolean flip, String category) {
        this.question = question;
        this.answer = answer;
        this.options = options;
        this.flip = flip;
        this.category = category;
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
