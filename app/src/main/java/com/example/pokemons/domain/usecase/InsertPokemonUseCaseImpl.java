package com.example.pokemons.domain.usecase;

import androidx.annotation.NonNull;

import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.domain.repository.PokemonRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

public class InsertPokemonUseCaseImpl implements InsertPokemonUseCase {

    @NonNull
    private final PokemonRepository pokemonRepository;

    @Inject
    public InsertPokemonUseCaseImpl(@NonNull PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public Completable insertPokemon(Pokemon pokemon) {
        return pokemonRepository.insertPokemon(new Pokemon(
                pokemon.getId(),
                pokemon.getImageUrl(),
                pokemon.getName(),
                pokemon.getHealth(),
                pokemon.getAttack(),
                pokemon.getDefense(),
                pokemon.getSpecialAttack()));
    }
}
