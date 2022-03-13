package com.example.pokemons.data.repository;

import static io.reactivex.annotations.SchedulerSupport.IO;

import android.annotation.SuppressLint;

import com.example.pokemons.data.datasource.database.PokemonDatabase;
import com.example.pokemons.data.datasource.network.NetworkPokemonDataSource;
import com.example.pokemons.data.mapper.EnemiesFromDatabaseToDomainMapper;
import com.example.pokemons.data.mapper.EnemiesFromNetworkToDatabaseMapper;
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
import io.reactivex.Maybe;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.schedulers.Schedulers;

public class PokemonRepositoryImpl implements PokemonRepository {

    private final PokemonDatabase database;
    private final NetworkPokemonDataSource networkPokemonDataSource;
    private final PokemonsFromNetworkToDamainMapper pokemonsFromNetworkToDamainMapper;
    private final PokemonFromDomainToDatabaseMapper pokemonFromDomainToDatabaseMapper;
    private final PokemonFromDatabaseToDomainMapper pokemonFromDatabaseToDomainMapper;
    private final EnemiesFromDatabaseToDomainMapper enemiesFromDatabaseToDomainMapper;
    private final EnemiesFromNetworkToDatabaseMapper enemiesFromNetworkToDatabaseMapper;

    @Inject
    public PokemonRepositoryImpl(
            PokemonDatabase database, NetworkPokemonDataSource networkPokemonDataSource,
            PokemonsFromNetworkToDamainMapper pokemonsFromNetworkToDamainMapper,
            PokemonFromDomainToDatabaseMapper pokemonFromDomainToDatabaseMapper,
            PokemonFromDatabaseToDomainMapper pokemonFromDatabaseToDomainMapper,
            EnemiesFromDatabaseToDomainMapper enemiesFromDatabaseToDomainMapper,
            EnemiesFromNetworkToDatabaseMapper enemiesFromNetworkToDatabaseMapper
    ) {
        this.database = database;
        this.networkPokemonDataSource = networkPokemonDataSource;
        this.pokemonsFromNetworkToDamainMapper = pokemonsFromNetworkToDamainMapper;
        this.pokemonFromDomainToDatabaseMapper = pokemonFromDomainToDatabaseMapper;
        this.pokemonFromDatabaseToDomainMapper = pokemonFromDatabaseToDomainMapper;
        this.enemiesFromDatabaseToDomainMapper = enemiesFromDatabaseToDomainMapper;
        this.enemiesFromNetworkToDatabaseMapper = enemiesFromNetworkToDatabaseMapper;
    }

    @Override
    public Completable insertPokemon(Pokemon pokemon) {
        return Completable.fromAction(() -> {
            database.getPokemonDao().clearAndInsert(pokemonFromDomainToDatabaseMapper.map(pokemon));
        });
    }

    @Override
    public Completable deleteEnemy(int id) {
        return Completable.fromAction(() -> {
            database.getEnemyDao().deleteEnemy(id);
        });
    }

    @Override
    public Maybe<Pokemon> getPokemonFromDatabase() {
        return database.getPokemonDao().getPokemon().map(pokemonFromDatabaseToDomainMapper::map);
    }

    @SuppressLint("CheckResult")
    @Override
    public Maybe<List<Pokemon>> getAllEnemies() {
        return database.getEnemyDao().getAllEnemy()
                .flatMap((enemies) -> {
                    if (enemies.size() == 0) {
                        return getRandomPokemons(7)
                                .doOnSuccess((pokemons -> {
                                    database.getEnemyDao()
                                            .saveEnemy(enemiesFromNetworkToDatabaseMapper.map(pokemons));
                                }));
                    } else {
                        return Maybe.just(enemiesFromDatabaseToDomainMapper.map(enemies));
                    }
                });


    }

    @Override
    public Maybe<List<Pokemon>> getRandomPokemons(int count) {
        Random random = new Random();
        List<Maybe<Pokemon>> pokemonRequests = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int id = random.nextInt(800) + i;
            pokemonRequests.add(getPokemon(id));
        }

        return Maybe.merge(pokemonRequests)
                .toList()
                .toMaybe();
    }

    @SchedulerSupport(IO)
    private Maybe<Pokemon> getPokemon(int id) {
        return networkPokemonDataSource.getPokemon(id)
                .map(pokemonsFromNetworkToDamainMapper::map)
                .subscribeOn(Schedulers.io());
    }
}
