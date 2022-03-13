package com.example.pokemons.domain.usecase.pokemon;

import androidx.annotation.NonNull;

import com.example.pokemons.domain.repository.PokemonRepository;

import io.reactivex.Completable;

public interface DeleteEnemyFromDatabaseUseCase {

    Completable deleteEnemy(int id);
}
