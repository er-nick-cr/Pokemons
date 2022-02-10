package com.example.pokemons.presentation.menu;

import android.annotation.SuppressLint;

import com.example.pokemons.BuildConfig;
import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.domain.usecase.GetRandomPokemonsUseCase;
import com.example.pokemons.domain.usecase.GetUserUseCase;
import com.example.pokemons.domain.usecase.InsertPokemonUseCase;
import com.example.pokemons.presentation.base.Presenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MenuPresenter extends Presenter<MenuView> {

    private final GetUserUseCase getUserUseCase;
    private final GetRandomPokemonsUseCase getRandomPokemonsUseCase;
    private final InsertPokemonUseCase insertPokemonUseCase;
    private Pokemon selectedPokemon;
    private final CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    public MenuPresenter(
            GetUserUseCase getUserUseCase,
            GetRandomPokemonsUseCase getRandomPokemonsUseCase,
            InsertPokemonUseCase insertPokemonUseCase
    ) {
        this.getUserUseCase = getUserUseCase;
        this.getRandomPokemonsUseCase = getRandomPokemonsUseCase;
        this.insertPokemonUseCase = insertPokemonUseCase;
    }

    @Override
    public void detachView() {
        super.detachView();
        disposable.clear();
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

    public void showPokemons() {
        disposable.add(
                getRandomPokemonsUseCase.getRandomPokemons(BuildConfig.POKEMONS_COUNT)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe((d) -> view.showLoading(true))
                        .doAfterTerminate(() -> view.showLoading(false))
                        .subscribe(
                                (pokemons) -> {
                                    view.showPokemonsList(pokemons);
                                },
                                (error) -> {
                                    view.showError();
                                }));
    }

    public void setSelectedPokemon(Pokemon selectedPokemon) {
        this.selectedPokemon = selectedPokemon;
    }

    public Pokemon getSelectedPokemon() {
        return selectedPokemon;
    }

    public void onChoosePokemonButtonCLick() {
        disposable.add(insertPokemonUseCase.insertPokemon(selectedPokemon)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> view.moveToMainMenuScreen()));
    }
}
