package com.example.pokemons.presentation.check;

import android.util.Pair;

import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.domain.entity.User;
import com.example.pokemons.domain.usecase.pokemon.GetPokemonFromDatabaseUseCase;
import com.example.pokemons.domain.usecase.user.GetUserUseCase;
import com.example.pokemons.presentation.base.Presenter;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class CheckPresenter extends Presenter<CheckView> {

    private final GetUserUseCase getUserUseCase;
    private final GetPokemonFromDatabaseUseCase getPokemonFromDatabaseUseCase;

    private final CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    public CheckPresenter(GetUserUseCase getUserUseCase, GetPokemonFromDatabaseUseCase getPokemonFromDatabaseUseCase) {
        this.getUserUseCase = getUserUseCase;
        this.getPokemonFromDatabaseUseCase = getPokemonFromDatabaseUseCase;
    }

    public void clearDisposable() {
        disposable.clear();
    }

    public void checkParams() {
        disposable.add(
                Maybe.zip(loadUser(), loadPokemon(), (user, pokemon) -> new Pair(user, pokemon))
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (userPokemonPair -> view.moveToMainMenuScreen()),
                        (error -> view.showError()),
                        (() -> view.moveToInsertNameScreen())
                ));
    }

    private Maybe<User> loadUser() {
        return getUserUseCase.getUser().subscribeOn(Schedulers.io());
    }

    private Maybe<Pokemon> loadPokemon() {
        return getPokemonFromDatabaseUseCase.getPokemon().subscribeOn(Schedulers.io());
    }


}
