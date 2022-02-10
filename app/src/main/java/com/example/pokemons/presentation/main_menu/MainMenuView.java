package com.example.pokemons.presentation.main_menu;

import com.example.pokemons.domain.entity.Pokemon;

public interface MainMenuView {
    void showPokemon(Pokemon pokemon);
    void showError();
}
