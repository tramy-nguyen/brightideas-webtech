package de.htwberlin.webtech.brightideas.web;

import java.util.List;

public class Set {

    private long id;
    private String title;
    private String description;
    private String subject;

    public Set (long id, String title, String description, String subject) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.subject = subject;
    }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
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

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }


}
