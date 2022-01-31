package com.example.pokemons.data.datasource.database;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert(onConflict = REPLACE)
    void insertUser(UserDataModel user);

    @Query("SELECT * FROM UserDataModel")
    UserDataModel getUser();
}
