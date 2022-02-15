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

        for (int i = 0; i < pokemons.size(); i++) {
            EnemyDbModel pokemon = new EnemyDbModel(pokemons.get(i).getId(),
                    pokemons.get(i).getImageUrl(),
                    pokemons.get(i).getName(),
                    pokemons.get(i).getHealth(),
                    pokemons.get(i).getAttack(),
                    pokemons.get(i).getDefense(),
                    pokemons.get(i).getSpecialAttack());
            enemies.add(pokemon);
        }
        return enemies;
    }

}
