package com.example.pokemons.domain.usecase;

import androidx.annotation.NonNull;

import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.domain.repository.PokemonRepository;

import io.reactivex.rxjava3.core.Single;

public class GetPokemonByIdUseCaseImpl implements GetPokemonByIdUseCase{

    @NonNull
    private final PokemonRepository repository;

    public GetPokemonByIdUseCaseImpl(@NonNull PokemonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Single<Pokemon> getPokemonById(String id) {
        return repository.getPokemon(id);
    }
}
