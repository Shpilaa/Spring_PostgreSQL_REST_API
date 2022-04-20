package com.example.demo.model;

import com.sun.istack.NotNull;
import org.springframework.boot.jackson.JsonComponent;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="seq2", initialValue=100, allocationSize=1)
@Table(name = "Managers")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq2")
    private long manager_id;

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "actor_id", referencedColumnName = "id")
    @OneToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;

    public Manager(long manager_id, String name, String surname, Actor actor) {
        this.manager_id = manager_id;
        this.name = name;
        this.surname = surname;
        this.actor = actor;
    }

    public Manager() {}

    public long getManager_id() {
        return manager_id;
    }

    public void setManager_id(long manager_id) {
        this.manager_id = manager_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}

