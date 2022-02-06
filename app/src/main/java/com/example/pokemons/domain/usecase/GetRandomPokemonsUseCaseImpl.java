package com.example.pokemons.domain.usecase;

import androidx.annotation.NonNull;

import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.domain.repository.PokemonRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetRandomPokemonsUseCaseImpl implements GetRandomPokemonsUseCase {

    @NonNull
    private final PokemonRepository repository;

    @Inject
    public GetRandomPokemonsUseCaseImpl(@NonNull PokemonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Single<List<Pokemon>> getRandomPokemons(int count) {
        return repository.getRandomPokemons(count);
    }
}
