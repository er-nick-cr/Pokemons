package com.example.pokemons.data.mapper;

import com.example.pokemons.data.datasource.database.entity.PokemonDbModel;
import com.example.pokemons.domain.entity.Pokemon;

import javax.inject.Inject;

public class PokemonFromDomainToDatabaseMapper {

    @Inject
    public PokemonFromDomainToDatabaseMapper() {

    }

    public PokemonDbModel map(Pokemon pokemon) {
        return new PokemonDbModel(
                pokemon.getId(),
                pokemon.getImageUrl(),
                pokemon.getName(),
                pokemon.getHealth(),
                pokemon.getAttack(),
                pokemon.getDefense(),
                pokemon.getSpecialAttack());
    }
}
