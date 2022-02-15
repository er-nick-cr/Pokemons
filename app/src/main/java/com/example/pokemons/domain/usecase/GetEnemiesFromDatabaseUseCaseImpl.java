package com.example.pokemons.domain.usecase;

import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.domain.repository.PokemonRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Maybe;

public class GetEnemiesFromDatabaseUseCaseImpl implements GetEnemiesFromDatabaseUseCase {

    private final PokemonRepository pokemonRepository;

    @Inject
    public GetEnemiesFromDatabaseUseCaseImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }


    @Override
    public Maybe<List<Pokemon>> getAllEnemies() {
        return pokemonRepository.getAllEnemies();
    }
}
