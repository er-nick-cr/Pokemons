package com.example.pokemons.domain.repository;

import com.example.pokemons.domain.entity.User;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface UserRepository {

    Single<User> getUser();

    Completable insertUser(User user);
}
