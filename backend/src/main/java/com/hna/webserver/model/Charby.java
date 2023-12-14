package com.hna.webserver.model;

import jakarta.persistence.*;

@Entity
@Table(name = "charbeez")
public class Charby {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    public Charby() {

    }

    public Charby(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Charby [id=" + id + ", name=" + name + "]";
    }


    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

}
