package com.example.pokemons.domain.repository;

import com.example.pokemons.domain.entity.Pokemon;

import java.util.List;

import io.reactivex.Single;

public interface PokemonRepository {

    Single<List<Pokemon>> getRandomPokemons(int count);
}
