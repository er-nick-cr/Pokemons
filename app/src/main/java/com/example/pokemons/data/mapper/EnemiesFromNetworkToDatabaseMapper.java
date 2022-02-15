package com.example.pokemons.data.mapper;

import com.example.pokemons.data.datasource.database.entity.EnemyDbModel;
import com.example.pokemons.data.datasource.network.entity.pokemonModel.PokemonModel;
import com.example.pokemons.domain.entity.Pokemon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class EnemiesFromNetworkToDatabaseMapper {

    @Inject
    public EnemiesFromNetworkToDatabaseMapper() {

    }

    public List<EnemyDbModel> map(List<Pokemon> pokemons) {
        List<EnemyDbModel> enemies = new ArrayList<>();
        pokemons.forEach((networkPokemon -> {
            EnemyDbModel pokemon = new EnemyDbModel(networkPokemon.getId(),
                    networkPokemon.getImageUrl(),
                    networkPokemon.getName(),
                    networkPokemon.getHealth(),
                    networkPokemon.getAttack(),
                    networkPokemon.getDefense(),
                    networkPokemon.getSpecialAttack());
            enemies.add(pokemon);
        }));
        return enemies;
    }

}
