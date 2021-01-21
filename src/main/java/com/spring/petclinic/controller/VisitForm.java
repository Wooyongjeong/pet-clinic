package com.spring.petclinic.controller;

public class VisitForm {
    private String visitDate;
    private String description;

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "VisitForm{" +
                "visitDate='" + visitDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
