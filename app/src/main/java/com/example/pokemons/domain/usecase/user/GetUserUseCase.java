package com.example.pokemons.domain.usecase.user;

import com.example.pokemons.domain.entity.User;

import io.reactivex.Maybe;

public interface GetUserUseCase {

    Maybe<User> getUser();
}
