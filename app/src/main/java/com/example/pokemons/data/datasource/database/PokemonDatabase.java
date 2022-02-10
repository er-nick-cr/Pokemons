package com.example.pokemons.data.datasource.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pokemons.BuildConfig;
import com.example.pokemons.data.datasource.database.entity.PokemonDbModel;
import com.example.pokemons.data.datasource.database.entity.UserDbModel;

@Database(entities = {UserDbModel.class, PokemonDbModel.class}, version = 5)
public abstract class PokemonDatabase extends RoomDatabase {

    private static PokemonDatabase db;

    public synchronized static PokemonDatabase getInstance(Context context) {
        if (db == null) {
            db = Room
                    .databaseBuilder(context.getApplicationContext(), PokemonDatabase.class, BuildConfig.DATA_BASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return db;
    }

    public abstract UserDao getUserDao();
    public abstract PokemonDao getPokemonDao();
}