package com.example.pokemons.presentation.fight_preview;

import android.util.Pair;

import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.domain.usecase.pokemon.GetEnemiesFromDatabaseUseCase;
import com.example.pokemons.domain.usecase.pokemon.GetPokemonFromDatabaseUseCase;
import com.example.pokemons.presentation.base.Presenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class FightPreviewPresenter extends Presenter<FightPreviewView> {

    private final GetPokemonFromDatabaseUseCase getPokemonFromDatabaseUseCase;
    private final GetEnemiesFromDatabaseUseCase getEnemiesFromDatabaseUseCase;
    private final CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    public FightPreviewPresenter(GetPokemonFromDatabaseUseCase getPokemonFromDatabaseUseCase,
                                 GetEnemiesFromDatabaseUseCase getEnemiesFromDatabaseUseCase
    ) {
        this.getPokemonFromDatabaseUseCase = getPokemonFromDatabaseUseCase;
        this.getEnemiesFromDatabaseUseCase = getEnemiesFromDatabaseUseCase;
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
                                (pokemonEnemyPair -> view.showFighters(pokemonEnemyPair.first, pokemonEnemyPair.second.get(0))),
                                (error -> view.showError())
                        )
        );
    }

    public void startFight() {
        view.moveToFight();
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