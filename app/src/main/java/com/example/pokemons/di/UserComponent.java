package com.example.pokemons.di;

import android.content.Context;

import com.example.pokemons.presentation.main_menu.MainMenuActivity;
import com.example.pokemons.presentation.menu.MenuActivity;
import com.example.pokemons.presentation.welcome.WelcomeActivity;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {UserModule.class, PokemonModule.class})
public interface UserComponent {

    void inject(WelcomeActivity welcomeActivity);

    void inject(MenuActivity menuActivity);

    void inject(MainMenuActivity mainMenuActivity);

    @Component.Factory
    interface Factory {
        UserComponent  create(@BindsInstance Context context);
    }
}
