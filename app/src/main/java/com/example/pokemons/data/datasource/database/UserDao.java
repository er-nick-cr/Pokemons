package com.example.pokemons.data.datasource.database;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.pokemons.data.datasource.database.entity.UserDbModel;

import io.reactivex.Single;

@Dao
public abstract class UserDao {

    @Query("SELECT * FROM UserDbModel")
    public abstract Single<UserDbModel> getUser();

    @Insert(onConflict = REPLACE)
    abstract public void insertUser(UserDbModel user);

    @Query("DELETE FROM UserDbModel")
    abstract public void nukeTable();

    @Transaction
    public void clearAndInsert(UserDbModel userDbModel) {
        nukeTable();
        insertUser(userDbModel);
    }
}
