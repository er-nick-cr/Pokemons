package com.example.pokemons.data.mapper;

import androidx.room.Insert;

import com.example.pokemons.data.datasource.database.UserDataModel;
import com.example.pokemons.domain.entity.User;

import javax.inject.Inject;

public class UserFromDatabaseToDomainMapper {

    @Inject
    public  UserFromDatabaseToDomainMapper() {

    }

    public User map(UserDataModel userDataModel) {
        return new User(userDataModel.getName());
    }
}
