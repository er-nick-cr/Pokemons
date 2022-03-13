package com.example.pokemons.domain.usecase.pokemon;

import androidx.annotation.NonNull;

import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.domain.repository.PokemonRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Maybe;

public class GetRandomPokemonsUseCaseImpl implements GetRandomPokemonsUseCase {

    @NonNull
    private final PokemonRepository repository;

    @Inject
    public GetRandomPokemonsUseCaseImpl(@NonNull PokemonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Maybe<List<Pokemon>> getRandomPokemons(int count) {
        return repository.getRandomPokemons(count);
    }
}
