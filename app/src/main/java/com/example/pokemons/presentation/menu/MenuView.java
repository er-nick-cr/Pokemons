package com.example.pokemons.presentation.menu;

import com.example.pokemons.domain.entity.Pokemon;

import java.util.List;

public interface MenuView {

    void setUserName(String name);
    void showError();
    void showPokemonsList(List<Pokemon> pokemons);
    void showLoading(boolean isLoading);
    void moveToMainMenuScreen();
}
