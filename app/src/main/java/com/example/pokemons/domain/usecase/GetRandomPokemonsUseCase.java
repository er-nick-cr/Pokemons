package com.example.pokemons.domain.usecase;

import com.example.pokemons.domain.entity.Pokemon;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Observable;

public interface GetRandomPokemonsUseCase {
   Maybe<List<Pokemon>> getRandomPokemons(int count);
}
