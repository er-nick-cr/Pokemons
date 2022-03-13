package com.example.pokemons.presentation.check;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.pokemons.PokemonApplication;
import com.example.pokemons.R;
import com.example.pokemons.presentation.main_menu.MainMenuActivity;
import com.example.pokemons.presentation.menu.ChoosePokemonActivity;
import com.example.pokemons.presentation.welcome.InsertNameActivity;

import javax.inject.Inject;

public class CheckActivity extends AppCompatActivity implements CheckView {

    @Inject
    CheckPresenter checkPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        PokemonApplication application = (PokemonApplication) getApplicationContext();
        application.getUserComponent()
                .inject(this);

        checkPresenter.attachView(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        checkPresenter.checkParams();
    }

    @Override
    protected void onStop() {
        super.onStop();

       checkPresenter.clearDisposable();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        checkPresenter.detachView();
    }

    @Override
    public void showError() {
        Toast.makeText(CheckActivity.this, R.string.name_error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void moveToInsertNameScreen() {
        Intent intent = new Intent(CheckActivity.this, InsertNameActivity.class);
        startActivity(intent);
    }

    @Override
    public void moveToMainMenuScreen() {
        Intent intent = new Intent(CheckActivity.this, MainMenuActivity.class);
        startActivity(intent);
    }
}