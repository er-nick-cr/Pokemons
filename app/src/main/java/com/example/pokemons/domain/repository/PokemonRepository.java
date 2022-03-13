package com.example.pokemons.domain.repository;

import com.example.pokemons.domain.entity.Pokemon;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;

public interface PokemonRepository {

    Maybe<List<Pokemon>> getRandomPokemons(int count);

    Maybe<Pokemon> getPokemonFromDatabase();

    Maybe<List<Pokemon>> getAllEnemies();

    Completable insertPokemon(Pokemon pokemon);

    Completable deleteEnemy(int id);
}
