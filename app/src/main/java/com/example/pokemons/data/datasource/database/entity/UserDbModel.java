package com.example.pokemons.data.datasource.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import javax.inject.Inject;

@Entity
public class UserDbModel {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "user")
    private final String name;

    @Inject
    public UserDbModel(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getName() {
        return name;
    }
}
