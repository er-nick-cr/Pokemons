package com.example.pokemons.presentation.check;

import android.util.Log;
import android.util.Pair;

import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.domain.entity.User;
import com.example.pokemons.domain.usecase.GetPokemonFromDatabaseUseCase;
import com.example.pokemons.domain.usecase.GetUserUseCase;
import com.example.pokemons.presentation.base.Presenter;
import com.example.pokemons.presentation.main_menu.MainMenuPresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class CheckPresenter extends Presenter<CheckView> {

    private final GetUserUseCase getUserUseCase;
    private final GetPokemonFromDatabaseUseCase getPokemonFromDatabaseUseCase;

    private final CompositeDisposable disposable = new CompositeDisposable();

    @Override
    public void detachView() {
        super.detachView();
        disposable.clear();
    }

    @Inject
    public CheckPresenter(GetUserUseCase getUserUseCase, GetPokemonFromDatabaseUseCase getPokemonFromDatabaseUseCase) {
        this.getUserUseCase = getUserUseCase;
        this.getPokemonFromDatabaseUseCase = getPokemonFromDatabaseUseCase;
    }

    public void checkParams() {
        disposable.add(
                Maybe.zip(loadUser(), loadPokemon(), (user, pokemon) -> new Pair(user, pokemon))
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (userPokemonPair -> view.moveToMainMenuScreen()),
                        (error -> view.showError()),
                        (() -> view.moveToWelcomeScreen())
                ));

    }

    private Maybe<User> loadUser() {
        return getUserUseCase.getUser().subscribeOn(Schedulers.io());
    }

    private Maybe<Pokemon> loadPokemon() {
        return getPokemonFromDatabaseUseCase.getPokemon().subscribeOn(Schedulers.io());
    }


}
