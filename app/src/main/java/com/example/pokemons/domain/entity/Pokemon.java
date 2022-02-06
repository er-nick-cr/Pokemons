package com.example.pokemons.domain.entity;

public class Pokemon {

    private final int id;
    private final String imageUrl;
    private final String name;
    private final int health;
    private final int attack;
    private final int defense;
    private final int specialAttack;

    public Pokemon(int id, String imageUrl, String name, int health, int attack, int defense, int specialAttack) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
    }

    public int getId() {return id;}
    public String getImageUrl() {return imageUrl;}

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }
}
