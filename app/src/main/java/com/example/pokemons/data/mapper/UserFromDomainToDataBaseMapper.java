package com.example.pokemons.data.mapper;

import com.example.pokemons.data.datasource.database.entity.UserDbModel;
import com.example.pokemons.domain.entity.User;

import javax.inject.Inject;

public class UserFromDomainToDataBaseMapper {

    @Inject
    public UserFromDomainToDataBaseMapper() {

    }

    public UserDbModel map(User user) {
        return new UserDbModel(user.getName());
    }
}
