package de.htwberlin.webtech.brightideas.web;

import java.util.List;

public class SetManipulationRequest {

    private String title;
    private String description;
    private String subject;

    public SetManipulationRequest (String title, String description, String subject ){
        this.title = title;
        this.description = description;
        this.subject = subject;
    }

    public SetManipulationRequest () {}

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
