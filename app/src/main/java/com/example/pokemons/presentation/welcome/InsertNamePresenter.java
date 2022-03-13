package com.example.pokemons.presentation.welcome;

import android.text.TextUtils;

import com.example.pokemons.domain.usecase.user.InsertUserUseCase;
import com.example.pokemons.presentation.base.Presenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class InsertNamePresenter extends Presenter<InsertNameView> {

    private final InsertUserUseCase insertUserUseCase;
    private final CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    public InsertNamePresenter(InsertUserUseCase insertUserUseCase) {
        this.insertUserUseCase = insertUserUseCase;
    }

    public void clearDisposable() {
        disposable.clear();
    }

    public void onEnterButtonClick(String inputValue) {
        if(TextUtils.isEmpty(inputValue.trim())) {
            view.showEmptyNameFieldError();
        } else {
            disposable.add(insertUserUseCase.insertUser(inputValue)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(() -> view.moveToChoosePokemonScreen()));
        }
    }
}
