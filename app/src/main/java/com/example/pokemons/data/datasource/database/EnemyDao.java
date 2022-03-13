package com.example.pokemons.data.datasource.database;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.pokemons.data.datasource.database.entity.EnemyDbModel;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public abstract class EnemyDao {

    @Insert(onConflict = REPLACE)
    abstract public void saveEnemy(List<EnemyDbModel> enemyPokemonDbModels);

    @Query("SELECT * FROM EnemyDbModel")
    abstract public Maybe<List<EnemyDbModel>> getAllEnemy();

    @Query("DELETE FROM EnemyDbModel WHERE id = :enemyId")
    abstract public void deleteEnemy(int enemyId);
}
