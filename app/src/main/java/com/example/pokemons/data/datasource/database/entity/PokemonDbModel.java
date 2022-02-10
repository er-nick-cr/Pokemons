package com.example.pokemons.data.datasource.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PokemonDbModel {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private final int id;

    @ColumnInfo(name = "imageUrl")
    private final String imageUrl;

    @ColumnInfo(name = "name")
    private final String name;

    @ColumnInfo(name = "health")
    private final int health;

    @ColumnInfo(name = "attack")
    private final int attack;

    @ColumnInfo(name = "defence")
    private final int defense;

    @ColumnInfo(name = "specialAttack")
    private final int specialAttack;


    public PokemonDbModel(int id, String imageUrl, String name, int health, int attack, int defense, int specialAttack) {
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
