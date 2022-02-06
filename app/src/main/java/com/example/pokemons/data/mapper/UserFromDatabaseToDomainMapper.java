package com.example.pokemons.data.mapper;

import com.example.pokemons.data.datasource.database.entity.UserDbModel;
import com.example.pokemons.domain.entity.User;

import javax.inject.Inject;

import io.reactivex.Single;

public class UserFromDatabaseToDomainMapper {

    @Inject
    public  UserFromDatabaseToDomainMapper() {

    }

    public User map(UserDbModel userDBModel) {
        return new User(userDBModel.getName());
    }
}
