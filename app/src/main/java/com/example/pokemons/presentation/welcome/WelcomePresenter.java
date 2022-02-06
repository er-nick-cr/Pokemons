package com.example.pokemons.presentation.welcome;

import android.text.TextUtils;

import com.example.pokemons.domain.entity.User;
import com.example.pokemons.domain.usecase.GetUserUseCase;
import com.example.pokemons.domain.usecase.InsertUserUseCase;
import com.example.pokemons.presentation.base.Presenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class WelcomePresenter extends Presenter<WelcomeView> {

    private final InsertUserUseCase insertUserUseCase;

    @Inject
    public WelcomePresenter(InsertUserUseCase insertUserUseCase) {
        this.insertUserUseCase = insertUserUseCase;
    }

    public void onEnterButtonClick(String inputValue) {
        if(TextUtils.isEmpty(inputValue.trim())) {
            view.showEmptyNameFieldError();
        } else {
            insertUserUseCase.insertUser(inputValue)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(() -> view.moveToMenuScreen());
        }
    }
}
