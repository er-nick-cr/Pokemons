package com.example.pokemons.data.mapper;

import com.example.pokemons.data.datasource.network.entity.pokemonModel.PokemonModel;
import com.example.pokemons.domain.entity.Pokemon;

import javax.inject.Inject;

public class PokemonsFromNetworkToDamainMapper {

    @Inject
    public PokemonsFromNetworkToDamainMapper() {

    }

    public Pokemon map(PokemonModel pokemonModel) {
        return new Pokemon(
                pokemonModel.hashCode(),
                pokemonModel.getSprites().getFrontDefault(),
                pokemonModel.getName(),
                pokemonModel.getStats().get(0).getBaseStat(),
                pokemonModel.getStats().get(1).getBaseStat(),
                pokemonModel.getStats().get(2).getBaseStat(),
                pokemonModel.getStats().get(3).getBaseStat());
    }
}
