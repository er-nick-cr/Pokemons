package com.example.pokemons.data.repository;

import static io.reactivex.annotations.SchedulerSupport.IO;

import com.example.pokemons.data.datasource.database.PokemonDatabase;
import com.example.pokemons.data.datasource.network.NetworkPokemonDataSource;
import com.example.pokemons.data.mapper.PokemonFromDatabaseToDomainMapper;
import com.example.pokemons.data.mapper.PokemonFromDomainToDatabaseMapper;
import com.example.pokemons.data.mapper.PokemonsFromNetworkToDamainMapper;
import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.domain.repository.PokemonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.schedulers.Schedulers;

public class PokemonRepositoryImpl implements PokemonRepository {

    private final PokemonDatabase database;
    private final NetworkPokemonDataSource networkPokemonDataSource;
    private final PokemonsFromNetworkToDamainMapper pokemonsFromNetworkToDamainMapper;
    private final PokemonFromDomainToDatabaseMapper pokemonFromDomainToDatabaseMapper;
    private final PokemonFromDatabaseToDomainMapper pokemonFromDatabaseToDomainMapper;

    @Inject
    public PokemonRepositoryImpl(
            PokemonDatabase database, NetworkPokemonDataSource networkPokemonDataSource,
            PokemonsFromNetworkToDamainMapper pokemonsFromNetworkToDamainMapper,
            PokemonFromDomainToDatabaseMapper pokemonFromDomainToDatabaseMapper,
            PokemonFromDatabaseToDomainMapper pokemonFromDatabaseToDomainMapper) {
        this.database = database;
        this.networkPokemonDataSource = networkPokemonDataSource;
        this.pokemonsFromNetworkToDamainMapper = pokemonsFromNetworkToDamainMapper;
        this.pokemonFromDomainToDatabaseMapper = pokemonFromDomainToDatabaseMapper;
        this.pokemonFromDatabaseToDomainMapper = pokemonFromDatabaseToDomainMapper;
    }

    @Override
    public Completable insertPokemon(Pokemon pokemon) {
        return Completable.fromAction(() -> {
            database.getPokemonDao().clearAndInsert(pokemonFromDomainToDatabaseMapper.map(pokemon));
        });
    }

    @Override
    public Single<Pokemon> getPokemonFromDatabase() {
        return database.getPokemonDao().getPokemon().map(pokemonFromDatabaseToDomainMapper::map);
    }

    @Override
    public Single<List<Pokemon>> getRandomPokemons(int count) {
        Random random = new Random();
        List<Single<Pokemon>> pokemonRequests = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            int id = random.nextInt(800) + i;
            pokemonRequests.add(getPokemon(id));
        }

        return Single.merge(pokemonRequests)
                .toList();
    }

    @SchedulerSupport(IO)
    private Single<Pokemon> getPokemon(int id) {
        return networkPokemonDataSource.getPokemon(id)
                .map(pokemonsFromNetworkToDamainMapper::map)
                .subscribeOn(Schedulers.io());
    }
}
