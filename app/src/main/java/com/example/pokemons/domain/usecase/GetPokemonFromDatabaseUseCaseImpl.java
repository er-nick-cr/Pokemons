package com.example.pokemons.domain.usecase;

import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.domain.repository.PokemonRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetPokemonFromDatabaseUseCaseImpl implements GetPokemonFromDatabaseUseCase {

    private final PokemonRepository pokemonRepository;

    @Inject
    public GetPokemonFromDatabaseUseCaseImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public Single<Pokemon> getPokemon() {
        return pokemonRepository.getPokemonFromDatabase();
    }
}
