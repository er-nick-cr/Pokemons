package com.example.pokemons.data.mapper;

import com.example.pokemons.data.datasource.database.UserDataModel;
import com.example.pokemons.domain.entity.User;

import javax.inject.Inject;

public class UserFromDomainToDataBaseMapper {

    @Inject
    public UserFromDomainToDataBaseMapper() {

    }

    public UserDataModel map (User user) {
        return new UserDataModel(user.getName());
    }
}
