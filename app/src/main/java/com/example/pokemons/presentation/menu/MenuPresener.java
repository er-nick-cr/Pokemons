package com.example.pokemons.presentation.menu;

import com.example.pokemons.domain.usecase.GetUserUseCase;
import com.example.pokemons.domain.usecase.InsertUserUseCase;
import com.example.pokemons.presentation.welcome.WelcomeView;

import javax.inject.Inject;

public class MenuPresener {

    private MenuView view;
    private GetUserUseCase getUserUseCase;

    public void attachView(MenuView view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

    @Inject
    public MenuPresener(GetUserUseCase getUserUseCase) {
        this.getUserUseCase = getUserUseCase;
    }

    public void onActivityLoad() {
       view.setUserName(getUserUseCase.getUser().getName());
    }

}
