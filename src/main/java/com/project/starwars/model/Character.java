package com.project.starwars.model;

import jakarta.persistence.*;


@Entity
@Table(name = "`character`")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private String race;

    @Column(nullable = false)
    private Integer birthYear;

    @Column(nullable = false)
    private boolean gender;

    @Column(nullable = false)
    private String planet;  

    @Column(nullable = true, length = 2083)
    private String foto;

    public Character() {}
    public Character(String nome, String race, Integer birthYear, boolean gender, String planet, String foto) {
        this.nome = nome;
        this.race = race;
        this.birthYear = birthYear;
        this.gender = gender;
        this.planet = planet;
        this.foto = foto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}



