package com.example.pokemons.domain.usecase.pokemon;

import androidx.annotation.NonNull;

import com.example.pokemons.domain.repository.PokemonRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

public class DeleteEnemyFromDatabaseUseCaseImpl implements DeleteEnemyFromDatabaseUseCase {

    @NonNull
    private final PokemonRepository pokemonRepository;

    @Inject
    public DeleteEnemyFromDatabaseUseCaseImpl(@NonNull PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }


    @Override
    public Completable deleteEnemy(int id) {
        return pokemonRepository.deleteEnemy(id);
    }
}
