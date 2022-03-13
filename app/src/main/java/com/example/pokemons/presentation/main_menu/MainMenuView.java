package com.example.pokemons.presentation.main_menu;

import com.example.pokemons.domain.entity.Pokemon;

public interface MainMenuView {
    void setUserName(String userName);
    void showPokemon(Pokemon pokemon);
    void moveToInsertNameActivity();
    void showError();
    void enterArena();
}
