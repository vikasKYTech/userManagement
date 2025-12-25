package com.vikas.user.userManagement.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private int id;

    @Column(name = "NAME", length = 20, nullable = false)
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ABOUT")
    private String about;

    @Transient
    private List<Rating> ratings;

    public User(){};

    public User(int id, String name, String email, String about, List<Rating> ratings){
        this.id = id;
        this.name = name;
        this.email = email;
        this.about = about;
        this.ratings = ratings;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setAbout(String about){
        this.about = about;
    }

    public String getAbout(){
        return this.about;
    }

    public void setRatings(List<Rating> ratings){
        this.ratings = ratings;
    }

    public List<Rating> getRatings(){
        return this.ratings != null ? this.ratings : new ArrayList<>();
    }

    @Override
    public String toString(){
        return "ID: " + this.id +
                "NAME: " + this.name +
                "EMAIL: " + this.email +
                "ABOUT: " + this.about;
    }
}

