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
        enemiesFromDatabase.forEach((enemyDbModel -> {
            Pokemon pokemon = new Pokemon(enemyDbModel.getId(),
                    enemyDbModel.getImageUrl(),
                    enemyDbModel.getName(),
                    enemyDbModel.getHealth(),
                    enemyDbModel.getAttack(),
                    enemyDbModel.getDefense(),
                    enemyDbModel.getSpecialAttack());
            enemies.add(pokemon);
        }));
        return enemies;
    }
}
