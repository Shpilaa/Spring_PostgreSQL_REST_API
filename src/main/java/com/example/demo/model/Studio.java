package com.example.demo.model;


import javax.persistence.*;

@Entity
@Table(name = "Studios")
public class Studio {
    @Id
    private long studio_id;

    @Column(name = "studio_name")
    private String studio_name;

    @OneToOne
    @JoinColumn(name = "boss_id")
    private Boss boss;

    public Studio() {
    }

    public Studio(long studio_id, String studio_name, Boss boss) {
        this.studio_name = studio_name;
        this.boss = boss;
    }

    public long getStudio_id() {
        return studio_id;
    }

    public void setStudio_id(long studio_id) {
        this.studio_id = studio_id;
    }

    public String getStudio_name() {
        return studio_name;
    }

    public void setStudio_name(String studio_name) {
        this.studio_name = studio_name;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }
}
