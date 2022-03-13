package com.example.pokemons.presentation.fight;

import com.example.pokemons.domain.entity.Pokemon;

public interface FightView {

    void showFighters(Pokemon pokemon, Pokemon enemy);
    int getEnemyHealth();
    void setEnemyHealth(int currentHealth);
    int getPokemonHealth();
    void setPokemonHealth(int currentHealth);
    void onEnemyAttack(Pokemon pokemon, Pokemon enemy, int isLastEnemy);
    void showError();
    void moveToFightPreviewActivity();
    void setPokemonWinner();
    void setEnemyWinner();
    void moveToMainMenuActivity();
    void hideSpecialAttackButton();
}
