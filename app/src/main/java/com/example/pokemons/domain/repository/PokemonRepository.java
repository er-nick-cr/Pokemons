package com.example.pokemons.domain.repository;

import com.example.pokemons.data.datasource.database.PokemonDao;
import com.example.pokemons.domain.entity.Pokemon;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface PokemonRepository {

    Single<List<Pokemon>> getRandomPokemons(int count);

    Single<Pokemon> getPokemonFromDatabase();

    Completable insertPokemon(Pokemon pokemon);
}
