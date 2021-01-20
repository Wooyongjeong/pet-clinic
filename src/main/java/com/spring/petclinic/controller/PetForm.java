package com.spring.petclinic.controller;

public class PetForm {
    private String name;
    private String birthDate;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PetForm{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
