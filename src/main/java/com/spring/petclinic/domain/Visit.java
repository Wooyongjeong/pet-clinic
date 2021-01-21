package com.spring.petclinic.domain;

import com.spring.petclinic.controller.VisitForm;

import javax.persistence.*;

@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="pet_id")
    private Pet pet;

    private String visitDate;
    private String description;

    public Visit() {}

    public Visit(VisitForm form) {
        this.visitDate = form.getVisitDate();
        this.description = form.getDescription();
    }

    public void update(VisitForm form) {
        this.visitDate = form.getVisitDate();
        this.description = form.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

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
        return "Visit{" +
                "id=" + id +
                ", pet=" + pet +
                ", visitDate='" + visitDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
