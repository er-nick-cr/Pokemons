package com.example.pokemons.data.datasource.database;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.pokemons.data.datasource.database.entity.PokemonDbModel;

import io.reactivex.Maybe;

@Dao
public abstract class PokemonDao {

    @Query("SELECT * FROM PokemonDbModel")
    public abstract Maybe<PokemonDbModel> getPokemon();

    @Insert(onConflict = REPLACE)
    abstract public void insertPokemon(PokemonDbModel pokemonDbModel);

    @Query("DELETE FROM PokemonDbModel")
    abstract public void nukeTable();

    @Transaction
    public void clearAndInsert(PokemonDbModel pokemonDbModel) {
        nukeTable();
        insertPokemon(pokemonDbModel);
    }
}
