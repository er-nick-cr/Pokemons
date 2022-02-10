package com.example.pokemons.domain.usecase;

import com.example.pokemons.domain.entity.Pokemon;

import io.reactivex.Single;

public interface GetPokemonFromDatabaseUseCase {

    Single<Pokemon> getPokemon();
}
