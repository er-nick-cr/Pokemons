package com.example.pokemons.presentation.welcome;

import com.example.pokemons.domain.entity.User;
import com.example.pokemons.domain.usecase.GetUserUseCase;
import com.example.pokemons.domain.usecase.InsertUserUseCase;

import javax.inject.Inject;

public class WelcomePresenter {

    private WelcomeView view;
    private InsertUserUseCase insertUserUseCase;

    public void attachView(WelcomeView view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

    @Inject
    public WelcomePresenter(InsertUserUseCase insertUserUseCase) {
        this.insertUserUseCase = insertUserUseCase;
    }

    public void onEnterButtonClick(String inputValue) {
        if(inputValue.trim().equals("")) {
            view.showEmptyNameFieldError();
        } else {
            insertUserUseCase.insertUser(new User(inputValue));
            view.moveToMenuScreen();
        }
    }
}
