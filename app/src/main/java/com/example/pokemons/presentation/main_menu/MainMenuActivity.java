package com.example.pokemons.presentation.main_menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pokemons.PokemonApplication;
import com.example.pokemons.R;
import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.presentation.menu.MenuPresenter;
import com.example.pokemons.presentation.menu.recycler.MenuAdapter;

import javax.inject.Inject;

public class MainMenuActivity extends AppCompatActivity implements MainMenuView {

    @Inject
    MainMenuPresenter mainMenuPresenter;

    private TextView pokemonster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        PokemonApplication application = (PokemonApplication) getApplicationContext();
        application.getUserComponent()
                .inject(this);

        pokemonster = findViewById(R.id.pokemonster);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainMenuPresenter.attachView(this);
        mainMenuPresenter.loadPokemon();

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void showPokemon(Pokemon pokemon) {
        pokemonster.setText(pokemon.getName() + " "
                + pokemon.getHealth() + " "
                + pokemon.getAttack() + " "
                + pokemon.getDefense() + " "
                + pokemon.getSpecialAttack() + " "
                + pokemon.getImageUrl()
        );
    }

    @Override
    public void showError() {
        Toast.makeText(MainMenuActivity.this, R.string.name_error, Toast.LENGTH_LONG).show();
    }
}