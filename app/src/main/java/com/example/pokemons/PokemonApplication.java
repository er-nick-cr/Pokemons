package com.example.pokemons;

import android.app.Application;

import com.example.pokemons.di.DaggerUserComponent;
import com.example.pokemons.di.UserComponent;

public class PokemonApplication extends Application {

    private UserComponent userComponent;

    @Override
    public void onCreate() {
        super.onCreate();

       userComponent = DaggerUserComponent.factory()
                .create(this);
    }

    public UserComponent getUserComponent() {
        return userComponent;
    }
}
