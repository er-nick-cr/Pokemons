package com.example.pokemons.data.repository;

import com.example.pokemons.data.datasource.database.DataModule;
import com.example.pokemons.data.mapper.UserFromDatabaseToDomainMapper;
import com.example.pokemons.data.mapper.UserFromDomainToDataBaseMapper;
import com.example.pokemons.domain.entity.User;
import com.example.pokemons.domain.repository.UserRepository;

import javax.inject.Inject;

public class UserRepositoryImpl implements UserRepository {

    private final DataModule dataModule;
    private final UserFromDatabaseToDomainMapper userFromDatabaseToDomainMapper;
    private final UserFromDomainToDataBaseMapper userFromDomainToDataBaseMapper;

    @Inject
    public UserRepositoryImpl(DataModule dataModule,
                              UserFromDatabaseToDomainMapper userFromDatabaseToDomainMapper,
                              UserFromDomainToDataBaseMapper userFromDomainToDataBaseMapper
    ) {
        this.dataModule = dataModule;
        this.userFromDatabaseToDomainMapper = userFromDatabaseToDomainMapper;
        this.userFromDomainToDataBaseMapper = userFromDomainToDataBaseMapper;
    }

    @Override
    public User getUser() {
        return userFromDatabaseToDomainMapper.map(dataModule.getUserDao().getUser());
    }

    public void insertUser(User user) {
        dataModule.getUserDao().insertUser(userFromDomainToDataBaseMapper.map(user));
    }
}
