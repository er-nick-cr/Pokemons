package com.example.pokemons.presentation.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pokemons.PokemonApplication;
import com.example.pokemons.R;
import com.example.pokemons.data.datasource.database.DataModule;
import com.example.pokemons.data.repository.PokemonRepositoryImpl;

import javax.inject.Inject;

public class MenuActivity extends AppCompatActivity implements MenuView {

    @Inject
    MenuPresener menuPresener;

    public TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        userName = findViewById(R.id.user_name);
    }

    @Override
    protected void onStart() {
        super.onStart();

        PokemonApplication application = (PokemonApplication) getApplicationContext();
        application.getUserComponent()
                .inject(this);

        menuPresener.attachView(this);
        menuPresener.onActivityLoad();
    }

    @Override
    protected void onStop() {
        super.onStop();

        menuPresener.detachView();
    }

    @Override
    public void setUserName(String name) {
        userName.setText(name);
    }
}