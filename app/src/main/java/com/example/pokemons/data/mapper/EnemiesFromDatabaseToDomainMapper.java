package com.example.pokemons.data.mapper;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.pokemons.data.datasource.database.entity.EnemyDbModel;
import com.example.pokemons.domain.entity.Pokemon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class EnemiesFromDatabaseToDomainMapper {

    @Inject
    public EnemiesFromDatabaseToDomainMapper() {

    }

    public List<Pokemon> map(List<EnemyDbModel> enemiesFromDatabase) {
        List<Pokemon> enemies = new ArrayList<>();
        for (int i = 0; i < enemiesFromDatabase.size(); i++) {
            Pokemon pokemon = new Pokemon(enemiesFromDatabase.get(i).getId(),
                    enemiesFromDatabase.get(i).getImageUrl(),
                    enemiesFromDatabase.get(i).getName(),
                    enemiesFromDatabase.get(i).getHealth(),
                    enemiesFromDatabase.get(i).getAttack(),
                    enemiesFromDatabase.get(i).getDefense(),
                    enemiesFromDatabase.get(i).getSpecialAttack());
            enemies.add(pokemon);
        }
        return enemies;
    }
}
