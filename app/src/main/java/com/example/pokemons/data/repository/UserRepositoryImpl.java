package com.example.pokemons.data.repository;

import com.example.pokemons.data.datasource.database.PokemonDatabase;
import com.example.pokemons.data.mapper.UserFromDatabaseToDomainMapper;
import com.example.pokemons.data.mapper.UserFromDomainToDataBaseMapper;
import com.example.pokemons.domain.entity.User;
import com.example.pokemons.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class UserRepositoryImpl implements UserRepository {

    private final PokemonDatabase database;
    private final UserFromDatabaseToDomainMapper userFromDatabaseToDomainMapper;
    private final UserFromDomainToDataBaseMapper userFromDomainToDataBaseMapper;

    @Inject
    public UserRepositoryImpl(PokemonDatabase database,
                              UserFromDatabaseToDomainMapper userFromDatabaseToDomainMapper,
                              UserFromDomainToDataBaseMapper userFromDomainToDataBaseMapper
    ) {
        this.database = database;
        this.userFromDatabaseToDomainMapper = userFromDatabaseToDomainMapper;
        this.userFromDomainToDataBaseMapper = userFromDomainToDataBaseMapper;
    }

    @Override
    public Single<User> getUser() {
        return database.getUserDao().getUser().map((userDbModel) -> userFromDatabaseToDomainMapper.map(userDbModel));
    }

    public Completable insertUser(User user) {
        return Completable.fromAction(() -> {
            database.getUserDao().clearAndInsert(userFromDomainToDataBaseMapper.map(user));
        });
    }
}
