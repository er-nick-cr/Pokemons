package com.example.pokemons.data.datasource.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.pokemons.domain.entity.Pokemon;

import javax.inject.Inject;

@Entity
public class UserDataModel {

    @PrimaryKey @NonNull @ColumnInfo(name = "user")
    private String name;

    @Inject
    public UserDataModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
