package com.example.pokemons.presentation.check;

import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.domain.entity.User;

public interface CheckView {
    void showError();
    void moveToWelcomeScreen();
    void moveToMenuScreen();
    void moveToMainMenuScreen();
}
