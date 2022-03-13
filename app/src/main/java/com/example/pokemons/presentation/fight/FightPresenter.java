package com.example.pokemons.presentation.fight;

import android.os.Handler;
import android.util.Pair;

import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.domain.usecase.pokemon.DeleteEnemyFromDatabaseUseCase;
import com.example.pokemons.domain.usecase.pokemon.GetEnemiesFromDatabaseUseCase;
import com.example.pokemons.domain.usecase.pokemon.GetPokemonFromDatabaseUseCase;
import com.example.pokemons.presentation.base.Presenter;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class FightPresenter extends Presenter<FightView> {

    private final GetPokemonFromDatabaseUseCase getPokemonFromDatabaseUseCase;
    private final GetEnemiesFromDatabaseUseCase getEnemiesFromDatabaseUseCase;
    private final CompositeDisposable disposable = new CompositeDisposable();
    private final DeleteEnemyFromDatabaseUseCase deleteEnemyFromDatabaseUseCase;
    private boolean isSpecialAttackUsed = false;

    @Inject
    public FightPresenter(GetPokemonFromDatabaseUseCase getPokemonFromDatabaseUseCase, GetEnemiesFromDatabaseUseCase getEnemiesFromDatabaseUseCase, DeleteEnemyFromDatabaseUseCase deleteEnemyFromDatabaseUseCase) {
        this.getPokemonFromDatabaseUseCase = getPokemonFromDatabaseUseCase;
        this.getEnemiesFromDatabaseUseCase = getEnemiesFromDatabaseUseCase;
        this.deleteEnemyFromDatabaseUseCase = deleteEnemyFromDatabaseUseCase;
    }

    public void clearDisposable() {
        disposable.clear();
    }

    public void loadFighters() {
        disposable.add(
                Maybe.zip(loadPokemon(), loadEnemy(), Pair::new)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                (pokemonEnemyPair -> {
                                    view.showFighters(pokemonEnemyPair.first, pokemonEnemyPair.second.get(0));
                                    view.onEnemyAttack(pokemonEnemyPair.first, pokemonEnemyPair.second.get(0), pokemonEnemyPair.second.size());
                                }),
                                (error -> view.showError())
                        )
        );
    }

    public void attackEnemy(Pokemon pokemon, Pokemon enemy, boolean isSpecialAttack, int enemyPosition) {
        Random random = new Random();
        Handler handler = new Handler();
        int enemyHealth = view.getEnemyHealth() - Math.max(pokemon.getAttack() - enemy.getDefense() * (isSpecialAttack ? random.nextInt(3) + 2 : 1), 10);
        if (isSpecialAttack) {
            isSpecialAttackUsed = true;
        }
        if(isSpecialAttackUsed) {
            view.hideSpecialAttackButton();
        }
        view.setEnemyHealth(enemyHealth);
        if(enemyHealth <= 0) {
            view.setPokemonWinner();
            handler.postDelayed(() -> {
                    deleteEnemy(enemy, enemyPosition);
                }, 1000);
        } else {
            handler.postDelayed(() -> {
                int pokemonHealth = view.getPokemonHealth()  - Math.max(enemy.getAttack() - pokemon.getDefense(), 10);
                view.setPokemonHealth(pokemonHealth);
                if(pokemonHealth <= 0) {
                    view.setEnemyWinner();
                    view.moveToMainMenuActivity();
                }

        }, 1500);
    }
    }

    private Maybe<Pokemon> loadPokemon() {
        return getPokemonFromDatabaseUseCase.getPokemon()
                .subscribeOn(Schedulers.io());
    }

    private Maybe<List<Pokemon>> loadEnemy() {
        return getEnemiesFromDatabaseUseCase.getAllEnemies()
                .subscribeOn(Schedulers.io());
    }

    private void deleteEnemy(Pokemon enemy, int enemyPosition) {
        disposable.add(( deleteEnemyFromDatabaseUseCase.deleteEnemy(enemy.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if(enemyPosition == 1) {
                        view.moveToMainMenuActivity();
                    } else {
                        view.moveToFightPreviewActivity();
                    }

                })));
    }
}
