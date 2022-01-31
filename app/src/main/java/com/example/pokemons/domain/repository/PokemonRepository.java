package com.example.pokemons.domain.repository;

import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.domain.entity.User;

import io.reactivex.rxjava3.core.Single;

public interface PokemonRepository {

    Single<Pokemon> getPokemon(String id);
}
