package com.example.pokemons.domain.entity;

public class Pokemon {

    private final String name;
    private final int health;
    private final int attack;
    private final int defense;
    private final int specialAttack;

    public Pokemon(String name, int health, int attack, int defense, int specialAttack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
    }

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
