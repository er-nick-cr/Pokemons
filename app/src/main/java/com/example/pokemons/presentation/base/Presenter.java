package com.example.pokemons.presentation.base;

public abstract class Presenter<View> {

    protected View view;

    public void attachView(View view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

}
