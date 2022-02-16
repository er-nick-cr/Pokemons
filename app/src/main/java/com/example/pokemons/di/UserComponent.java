package com.example.pokemons.di;

import android.content.Context;

import com.example.pokemons.presentation.check.CheckActivity;
import com.example.pokemons.presentation.fight.FightActivity;
import com.example.pokemons.presentation.fight.FightPresenter;
import com.example.pokemons.presentation.fight_preview.FightPreviewActivity;
import com.example.pokemons.presentation.fight_preview.FightPreviewPresenter;
import com.example.pokemons.presentation.main_menu.MainMenuActivity;
import com.example.pokemons.presentation.menu.MenuActivity;
import com.example.pokemons.presentation.welcome.WelcomeActivity;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {UserModule.class, PokemonModule.class})
public interface UserComponent {

    void inject(CheckActivity checkActivity);

    void inject(WelcomeActivity welcomeActivity);

    void inject(MenuActivity menuActivity);

    void inject(MainMenuActivity mainMenuActivity);

    void inject(FightPreviewActivity fightPreviewActivity);

    void inject(FightActivity fightActivity);

    @Component.Factory
    interface Factory {
        UserComponent  create(@BindsInstance Context context);
    }
}
