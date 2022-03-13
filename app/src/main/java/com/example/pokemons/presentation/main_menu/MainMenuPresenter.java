package com.example.pokemons.presentation.main_menu;

import android.annotation.SuppressLint;

import com.example.pokemons.domain.usecase.pokemon.GetPokemonFromDatabaseUseCase;
import com.example.pokemons.domain.usecase.user.GetUserUseCase;
import com.example.pokemons.presentation.base.Presenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainMenuPresenter extends Presenter<MainMenuView> {

    private final GetPokemonFromDatabaseUseCase getPokemonFromDatabaseUseCase;
    private final GetUserUseCase getUserUseCase;
    private final CompositeDisposable disposable = new CompositeDisposable();

    @Override
    public void detachView() {
        super.detachView();
    }


    @Inject
    public MainMenuPresenter(GetPokemonFromDatabaseUseCase getPokemonFromDatabaseUseCase, GetUserUseCase getUserUseCase) {
        this.getPokemonFromDatabaseUseCase = getPokemonFromDatabaseUseCase;
        this.getUserUseCase = getUserUseCase;
    }

    @SuppressLint("CheckResult")
    public void loadUser() {
        disposable.add(
                getUserUseCase.getUser()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                (user) -> {
                                    view.setUserName(user.getName());
                                },
                                (error) -> {
                                    view.showError();
                                }));
    }

    public void clearDisposable() {
        disposable.clear();
    }

    public void loadPokemon() {
        disposable.add(
                getPokemonFromDatabaseUseCase.getPokemon()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((pokemon) -> {
                            view.showPokemon(pokemon);
                        },
                        (error) -> {
                            view.showError();
                        })
                );
    }

    public void changeAccountData() {
        view.moveToInsertNameActivity();
    }

    public void onEneterArenaButtonClick() {
        view.enterArena();
    }
}
