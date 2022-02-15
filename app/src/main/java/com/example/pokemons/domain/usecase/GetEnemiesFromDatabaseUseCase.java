package com.example.pokemons.domain.usecase;

import com.example.pokemons.domain.entity.Pokemon;

import java.util.List;

import io.reactivex.Maybe;

public interface GetEnemiesFromDatabaseUseCase {

    Maybe<List<Pokemon>> getAllEnemies();
}
