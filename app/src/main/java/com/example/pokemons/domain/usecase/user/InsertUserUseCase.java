package com.example.pokemons.domain.usecase.user;

import io.reactivex.Completable;

public interface InsertUserUseCase {

    Completable insertUser (String name);
}
