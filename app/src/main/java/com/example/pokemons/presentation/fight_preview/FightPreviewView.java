package com.example.pokemons.presentation.fight_preview;

import com.example.pokemons.domain.entity.Pokemon;

public interface FightPreviewView {

    void showFighters(Pokemon pokemon, Pokemon enemy);
    void showError();
}
