package com.example.pokemons.domain.usecase;

import io.reactivex.Completable;

public interface InsertUserUseCase {

    Completable insertUser (String name);
}
