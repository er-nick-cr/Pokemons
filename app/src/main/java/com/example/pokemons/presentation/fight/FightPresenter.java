package com.example.pokemons.presentation.fight;

import android.os.Handler;
import android.util.Pair;

import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.domain.usecase.GetEnemiesFromDatabaseUseCase;
import com.example.pokemons.domain.usecase.GetPokemonFromDatabaseUseCase;
import com.example.pokemons.presentation.base.Presenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class FightPresenter extends Presenter<FightView> {

    private final GetPokemonFromDatabaseUseCase getPokemonFromDatabaseUseCase;
    private final GetEnemiesFromDatabaseUseCase getEnemiesFromDatabaseUseCase;
    private final CompositeDisposable disposable = new CompositeDisposable();

    @Override
    public void detachView() {
        super.detachView();
        disposable.clear();
    }

    @Inject
    public FightPresenter(GetPokemonFromDatabaseUseCase getPokemonFromDatabaseUseCase, GetEnemiesFromDatabaseUseCase getEnemiesFromDatabaseUseCase) {
        this.getPokemonFromDatabaseUseCase = getPokemonFromDatabaseUseCase;
        this.getEnemiesFromDatabaseUseCase = getEnemiesFromDatabaseUseCase;
    }

    public void loadFighters() {
        disposable.add(
                Maybe.zip(loadPokemon(), loadEnemy(), Pair::new)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                (pokemonEnemyPair -> {
                                    view.showFighters(pokemonEnemyPair.first, pokemonEnemyPair.second.get(0));
                                    view.onEnemyAttack(pokemonEnemyPair.first, pokemonEnemyPair.second.get(0));
                                }),
                                (error -> view.showError())
                        )
        );
    }

    public void attackEnemy(Pokemon pokemon, Pokemon enemy) {
        Handler handler = new Handler();
        view.setEnemyHealth(view.getEnemyHealth() - pokemon.getAttack());
        handler.postDelayed(() -> {
            view.setPokemonHealth(view.getPokemonHealth() - enemy.getAttack());
        }, 1500);
    }

    private Maybe<Pokemon> loadPokemon() {
        return getPokemonFromDatabaseUseCase.getPokemon()
                .subscribeOn(Schedulers.io());
    }

    private Maybe<List<Pokemon>> loadEnemy() {
        return getEnemiesFromDatabaseUseCase.getAllEnemies()
                .subscribeOn(Schedulers.io());
    }
}
