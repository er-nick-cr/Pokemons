package com.example.pokemons.data.repository;

import com.example.pokemons.data.datasource.database.DataModule;
import com.example.pokemons.data.mapper.UserFromDatabaseToDomainMapper;
import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.domain.entity.User;
import com.example.pokemons.domain.repository.PokemonRepository;

import io.reactivex.rxjava3.core.Single;

public class PokemonRepositoryImpl implements PokemonRepository {

    @Override
    public Single<Pokemon> getPokemon(String id) {
        return null;
    }
}
