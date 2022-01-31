package com.example.pokemons.data.datasource.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pokemons.BuildConfig;
import com.example.pokemons.PokemonApplication;
import com.example.pokemons.di.UserComponent;

@Database(entities = {UserDataModel.class}, version = 2)
public abstract class DataModule extends RoomDatabase {

    private static DataModule db;

    public synchronized static DataModule getInstance(Context context) {
        if (db == null) {
            db = Room
                    .databaseBuilder(context.getApplicationContext(), DataModule.class, BuildConfig.DATA_BASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return db;
    }

    public abstract UserDao getUserDao();
}