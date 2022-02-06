package com.example.pokemons.domain.usecase;

import com.example.pokemons.domain.entity.User;

import io.reactivex.Single;

public interface GetUserUseCase {

    public Single<User> getUser();
}
