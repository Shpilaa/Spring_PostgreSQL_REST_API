package com.example.demo.model;


import javax.persistence.*;

@Entity
@SequenceGenerator(name="seq", initialValue=1000, allocationSize=1)
@Table(name = "Bosses")
public class Boss {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "salary")
    private int salary;

    public Boss(long id, String name, String surname, int salary) {
        super();
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public Boss() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
