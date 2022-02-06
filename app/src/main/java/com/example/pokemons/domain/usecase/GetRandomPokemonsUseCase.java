package com.example.pokemons.domain.usecase;

import com.example.pokemons.domain.entity.Pokemon;

import java.util.List;

import io.reactivex.Single;

public interface GetRandomPokemonsUseCase {
   Single<List<Pokemon>> getRandomPokemons(int count);
}
