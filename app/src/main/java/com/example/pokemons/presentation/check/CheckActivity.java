package com.example.pokemons.presentation.check;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import com.example.pokemons.PokemonApplication;
import com.example.pokemons.R;
import com.example.pokemons.presentation.main_menu.MainMenuActivity;
import com.example.pokemons.presentation.menu.MenuActivity;
import com.example.pokemons.presentation.welcome.WelcomeActivity;

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
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkPresenter.attachView(this);
        checkPresenter.checkParams();
    }


    @Override
    public void showError() {
        Toast.makeText(CheckActivity.this, R.string.name_error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void moveToWelcomeScreen() {
        Intent intent = new Intent(CheckActivity.this, WelcomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void moveToMenuScreen() {
        Intent intent = new Intent(CheckActivity.this, MenuActivity.class);
        startActivity(intent);
    }

    @Override
    public void moveToMainMenuScreen() {
        Intent intent = new Intent(CheckActivity.this, MainMenuActivity.class);
        startActivity(intent);
    }
}