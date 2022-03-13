package com.example.pokemons.domain.usecase.pokemon;

import com.example.pokemons.domain.entity.Pokemon;

import io.reactivex.Maybe;

public interface GetPokemonFromDatabaseUseCase {

    Maybe<Pokemon> getPokemon();
}
