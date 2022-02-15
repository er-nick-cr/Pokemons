package com.example.pokemons.domain.repository;

import com.example.pokemons.domain.entity.User;

import io.reactivex.Completable;
import io.reactivex.Maybe;

public interface UserRepository {

    Maybe<User> getUser();

    Completable insertUser(User user);
}
