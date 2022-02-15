package com.example.pokemons.domain.usecase;

import com.example.pokemons.domain.entity.Pokemon;

import io.reactivex.Maybe;

public interface GetPokemonFromDatabaseUseCase {

    Maybe<Pokemon> getPokemon();
}
