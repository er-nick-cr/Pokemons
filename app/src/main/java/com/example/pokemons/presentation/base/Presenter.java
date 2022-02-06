package com.example.pokemons.presentation.base;

import android.view.View;

import com.example.pokemons.presentation.menu.MenuView;

public abstract class Presenter<View> {

    protected View view;

    public void attachView(View view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

}
