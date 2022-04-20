//package com.example.demo.model;
//
//
//import com.sun.istack.NotNull;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "Movies")
//@IdClass(MovieId.class)
//public class Movie {
//    @Id
//    private String name;
//    @Id
//    private int year;
//
//    @Column(name = "duration")
//    private int duration;
//    @Column(name = "genre")
//    private String genre;
//
//    @NotNull
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "studio_name")
//    private Studio studio_name;
//
//    public Movie(String name, int year, int duration, String genre, Studio studio_name) {
//        super();
//        this.name = name;
//        this.year = year;
//        this.duration = duration;
//        this.genre = genre;
//        this.studio_name = studio_name;
//    }
//
//    public Movie() {
//        super();
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }
//
//    public int getDuration() {
//        return duration;
//    }
//
//    public void setDuration(int duration) {
//        this.duration = duration;
//    }
//
//    public String getGenre() {
//        return genre;
//    }
//
//    public void setGenre(String genre) {
//        this.genre = genre;
//    }
//
//    public Studio getStudio_name() {
//        return studio_name;
//    }
//
//    public void setStudio_name(Studio studio_name) {
//        this.studio_name = studio_name;
//    }
//}
