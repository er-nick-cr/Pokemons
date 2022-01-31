package com.example.pokemons.domain.usecase;

import com.example.pokemons.domain.entity.Pokemon;

import io.reactivex.rxjava3.core.Single;

public interface GetPokemonByIdUseCase {
   Single<Pokemon> getPokemonById(String id);
}
