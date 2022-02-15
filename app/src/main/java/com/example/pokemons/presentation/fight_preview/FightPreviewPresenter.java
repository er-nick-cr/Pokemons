package com.example.pokemons.presentation.fight_preview;

import android.util.Pair;

import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.domain.usecase.GetEnemiesFromDatabaseUseCase;
import com.example.pokemons.domain.usecase.GetPokemonFromDatabaseUseCase;
import com.example.pokemons.presentation.base.Presenter;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class FightPreviewPresenter extends Presenter<FightPreviewView> {

    private GetPokemonFromDatabaseUseCase getPokemonFromDatabaseUseCase;
    private GetEnemiesFromDatabaseUseCase getEnemiesFromDatabaseUseCase;
    private final CompositeDisposable disposable = new CompositeDisposable();

    @Override
    public void detachView() {
        super.detachView();
        disposable.clear();
    }

    @Inject
    public FightPreviewPresenter(GetPokemonFromDatabaseUseCase getPokemonFromDatabaseUseCase,
                                 GetEnemiesFromDatabaseUseCase getEnemiesFromDatabaseUseCase
    ) {
        this.getPokemonFromDatabaseUseCase = getPokemonFromDatabaseUseCase;
        this.getEnemiesFromDatabaseUseCase = getEnemiesFromDatabaseUseCase;
    }

    public void loadFighters() {
        disposable.add(
                Maybe.zip(loadPokemon(), loadEnemy(), (pokemon, enemy) -> new Pair<>(pokemon, enemy))
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe((result) -> {
                    view.showFighters(result.first, result.second);
                },
                        (error) -> {
                    view.showError();
                        })
        );

    }

    private Maybe<Pokemon> loadPokemon() {
       return getPokemonFromDatabaseUseCase.getPokemon()
                .subscribeOn(Schedulers.io());
    }

    private Maybe<Pokemon> loadEnemy() {
       return getEnemiesFromDatabaseUseCase.getAllEnemies()
                .subscribeOn(Schedulers.io())
                .map((enemies) -> enemies.get(0));
    }
}