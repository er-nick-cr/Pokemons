package com.example.pokemons.data.datasource.network;

import com.example.pokemons.data.datasource.network.entity.pokemonModel.PokemonModel;

import io.reactivex.Maybe;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonApi {

    @GET("{id}/")
    Maybe<PokemonModel> getPokemon(@Path("id") int id);
}
