package com.example.pokemons.domain.usecase.pokemon;

import com.example.pokemons.domain.entity.Pokemon;

import io.reactivex.Completable;

public interface InsertPokemonUseCase {

    Completable insertPokemon(Pokemon pokemon);
}
