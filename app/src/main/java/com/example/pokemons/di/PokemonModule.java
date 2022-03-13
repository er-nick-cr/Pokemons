package com.example.pokemons.di;

import com.example.pokemons.data.datasource.network.NetworkService;
import com.example.pokemons.data.repository.PokemonRepositoryImpl;
import com.example.pokemons.domain.repository.PokemonRepository;
import com.example.pokemons.domain.usecase.pokemon.DeleteEnemyFromDatabaseUseCase;
import com.example.pokemons.domain.usecase.pokemon.DeleteEnemyFromDatabaseUseCaseImpl;
import com.example.pokemons.domain.usecase.pokemon.GetEnemiesFromDatabaseUseCase;
import com.example.pokemons.domain.usecase.pokemon.GetEnemiesFromDatabaseUseCaseImpl;
import com.example.pokemons.domain.usecase.pokemon.GetPokemonFromDatabaseUseCase;
import com.example.pokemons.domain.usecase.pokemon.GetPokemonFromDatabaseUseCaseImpl;
import com.example.pokemons.domain.usecase.pokemon.GetRandomPokemonsUseCase;
import com.example.pokemons.domain.usecase.pokemon.GetRandomPokemonsUseCaseImpl;
import com.example.pokemons.domain.usecase.pokemon.InsertPokemonUseCase;
import com.example.pokemons.domain.usecase.pokemon.InsertPokemonUseCaseImpl;

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

    @Binds
    public abstract GetEnemiesFromDatabaseUseCase bindGetEnemiesFromDatabaseUseСase(GetEnemiesFromDatabaseUseCaseImpl impl);

    @Binds
    public abstract DeleteEnemyFromDatabaseUseCase bindDeleteEnemyFromDatabaseUseCase(DeleteEnemyFromDatabaseUseCaseImpl impl);
}
