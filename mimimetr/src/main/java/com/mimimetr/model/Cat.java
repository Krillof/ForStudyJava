package com.mimimetr.model;

import javax.persistence.*;

@Entity
@Table(name="Cat")
public class Cat {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;


    @Column(name="picture", length = 10000000)
    private byte[] picture;

    @Column(name="rating")
    private int rating;

    public Cat(Long id, String name, byte[] picture, int rating) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.rating = rating;
    }

    public Cat() {
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public int getRating() {
        return rating;
    }

    public String getRatingForShow(){
        return "Rating: " + rating;
    }

    public String getStrForGettingPicture(){
        return "/get_picture/" + this.getId();
    }

    public void setRating(int rating) {
        this.rating = rating;
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
}
