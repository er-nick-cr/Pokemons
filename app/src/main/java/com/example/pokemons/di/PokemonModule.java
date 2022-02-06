package com.example.pokemons.di;

import com.example.pokemons.data.datasource.network.NetworkService;
import com.example.pokemons.data.repository.PokemonRepositoryImpl;
import com.example.pokemons.domain.repository.PokemonRepository;
import com.example.pokemons.domain.usecase.GetRandomPokemonsUseCase;
import com.example.pokemons.domain.usecase.GetRandomPokemonsUseCaseImpl;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class PokemonModule {

    @Provides
    public static NetworkService networkService() {
        return NetworkService.getInstance();
    }

    @Binds
    public abstract PokemonRepository bindPokemonRepository(PokemonRepositoryImpl impl);

    @Binds
    public abstract GetRandomPokemonsUseCase bindGetPokemonByIdUseCase(GetRandomPokemonsUseCaseImpl impl);
}
