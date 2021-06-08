package com.zubets.fishApp.entity;

import javax.persistence.*;

@Entity
@Table(name = "fish")
public class FishClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "typeOfFish")
    private String typeOfFish;
    @Column(name = "description")
    private String description;

    public FishClass(){

    }

    public FishClass(int id, String name, String typeOfFish, String description) {
        this.id = id;
        this.name = name;
        this.typeOfFish = typeOfFish;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfFish() {
        return typeOfFish;
    }

    public void setTypeOfFish(String typeOfFish) {
        this.typeOfFish = typeOfFish;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
