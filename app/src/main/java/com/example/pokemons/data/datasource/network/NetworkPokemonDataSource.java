package com.example.pokemons.data.datasource.network;

import com.example.pokemons.data.datasource.network.pokemonModel.PokemonModel;

import io.reactivex.rxjava3.core.Single;

public class NetworkPokemonDataSource {

    private final PokemonApi api;

    public NetworkPokemonDataSource(PokemonApi api) {
        this.api = api;
    }

    public Single<PokemonModel> getPokemon(String id) {
        return api.getPokemon(id);
    }
}
