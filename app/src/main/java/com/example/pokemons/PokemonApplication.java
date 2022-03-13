package com.example.pokemons;

import android.app.Application;

import com.example.pokemons.di.ApplicationComponent;
import com.example.pokemons.di.DaggerApplicationComponent;

public class PokemonApplication extends Application {

    private ApplicationComponent userComponent;

    @Override
    public void onCreate() {
        super.onCreate();

       userComponent = DaggerApplicationComponent.factory()
                .create(this);
    }

    public ApplicationComponent getUserComponent() {
        return userComponent;
    }
}
