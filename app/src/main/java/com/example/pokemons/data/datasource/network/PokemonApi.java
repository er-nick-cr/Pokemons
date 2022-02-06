package com.example.pokemons.data.datasource.network;

import com.example.pokemons.data.datasource.network.entity.pokemonModel.PokemonModel;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonApi {

    @GET("{id}/")
    Single<PokemonModel> getPokemon(@Path("id") int id);
}
