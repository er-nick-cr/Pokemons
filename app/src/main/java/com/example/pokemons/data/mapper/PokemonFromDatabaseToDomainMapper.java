package com.example.pokemons.data.mapper;

import com.example.pokemons.data.datasource.database.entity.PokemonDbModel;
import com.example.pokemons.domain.entity.Pokemon;

import javax.inject.Inject;

public class PokemonFromDatabaseToDomainMapper {

    @Inject
    public PokemonFromDatabaseToDomainMapper() {

    }

    public Pokemon map(PokemonDbModel pokemonDbModel) {
        return new Pokemon(pokemonDbModel.getId(),
                pokemonDbModel.getImageUrl(),
                pokemonDbModel.getName(),
                pokemonDbModel.getHealth(),
                pokemonDbModel.getAttack(),
                pokemonDbModel.getDefense(),
                pokemonDbModel.getSpecialAttack());
    }
}
