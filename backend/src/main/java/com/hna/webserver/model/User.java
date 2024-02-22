package com.hna.webserver.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    public User() {

    }

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password; 
        this.email = email; 
    }

    public User(String name, String email, String username, String password){
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword(){
        return password; 
    }

    public String getEmail(){
        return email; 
    }

    public String getUsername(){
        return username; 
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", username=" + username+"], " + "password=" + password+", email=" + email;
    }

    @OneToMany (mappedBy = "user")
    private List<Charby> charby;


}
