package com.spring.petclinic.domain;

import com.spring.petclinic.controller.PetForm;

import javax.persistence.*;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String birthDate;
    private String type;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;

    public Pet() {}

    public Pet(PetForm form) {
        this.name = form.getName();
        this.birthDate = form.getBirthDate();
        this.type = form.getType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", type='" + type + '\'' +
                ", owner=" + owner +
                '}';
    }
}
