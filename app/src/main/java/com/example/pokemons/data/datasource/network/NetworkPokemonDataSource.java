package com.example.pokemons.data.datasource.network;

import com.example.pokemons.data.datasource.network.entity.pokemonModel.PokemonModel;

import javax.inject.Inject;

import io.reactivex.Maybe;

public class NetworkPokemonDataSource {

    private final NetworkService networkService;

    @Inject
    public NetworkPokemonDataSource(NetworkService networkService) {

        this.networkService = networkService;
    }

    public Maybe<PokemonModel> getPokemon(int id) {
        return networkService.getApi().getPokemon(id);
    }
}
