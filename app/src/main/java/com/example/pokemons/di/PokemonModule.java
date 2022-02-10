package com.example.pokemons.di;

import android.content.Context;

import com.example.pokemons.data.datasource.database.PokemonDatabase;
import com.example.pokemons.data.datasource.network.NetworkService;
import com.example.pokemons.data.repository.PokemonRepositoryImpl;
import com.example.pokemons.domain.repository.PokemonRepository;
import com.example.pokemons.domain.usecase.GetPokemonFromDatabaseUseCase;
import com.example.pokemons.domain.usecase.GetPokemonFromDatabaseUseCaseImpl;
import com.example.pokemons.domain.usecase.GetRandomPokemonsUseCase;
import com.example.pokemons.domain.usecase.GetRandomPokemonsUseCaseImpl;
import com.example.pokemons.domain.usecase.InsertPokemonUseCase;
import com.example.pokemons.domain.usecase.InsertPokemonUseCaseImpl;

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

    @Binds
    public abstract InsertPokemonUseCase bindInsertPokemonUseCase(InsertPokemonUseCaseImpl impl);

    @Binds
    public abstract GetPokemonFromDatabaseUseCase bindGetPokemonFromDatabaseUseCase(GetPokemonFromDatabaseUseCaseImpl impl);
}
