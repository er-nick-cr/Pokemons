package com.example.pokemons.presentation.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pokemons.PokemonApplication;
import com.example.pokemons.R;
import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.presentation.main_menu.MainMenuActivity;
import com.example.pokemons.presentation.menu.recycler.MenuAdapter;

import java.util.List;

import javax.inject.Inject;

public class ChoosePokemonActivity extends AppCompatActivity implements ChoosePokemonView {

    @Inject
    ChoosePokemonPresenter choosePokemonPresenter;

    public MenuAdapter adapter;
    public TextView userName;
    public ConstraintLayout progress;
    public RecyclerView recyclerView;
    public Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_pokemon);

        PokemonApplication application = (PokemonApplication) getApplicationContext();
        application.getUserComponent()
                .inject(this);

        choosePokemonPresenter.attachView(this);

        userName = findViewById(R.id.user_name);
        progress = findViewById(R.id.loader);
        continueButton = findViewById(R.id.insert_pokemon_button);
        adapter = new MenuAdapter(this::onItemClickListener);
        recyclerView = findViewById(R.id.main_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        continueButton.setOnClickListener((v) -> {
            choosePokemonPresenter.onChoosePokemonButtonCLick();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        choosePokemonPresenter.loadUser();
        choosePokemonPresenter.showPokemons();
    }

    @Override
    protected void onStop() {
        super.onStop();

        choosePokemonPresenter.clearDisposable();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        choosePokemonPresenter.detachView();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setUserName(String name) {
        userName.setText("Hello, " + name);
    }

    @Override
    public void showError() {
        Toast.makeText(ChoosePokemonActivity.this, R.string.database_error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showPokemonsList(List<Pokemon> pokemons) {
        adapter.setPokemons(pokemons);
    }

    @Override
    public void showLoading(boolean isLoading) {
        progress.setVisibility(isLoading ? View.VISIBLE : View.GONE);
        recyclerView.setVisibility(isLoading ? View.GONE : View.VISIBLE);
    }

    @Override
    public void moveToMainMenuScreen() {
        Intent intent = new Intent(ChoosePokemonActivity.this, MainMenuActivity.class);
        startActivity(intent);
    }

    @SuppressLint("SetTextI18n")
    public void onItemClickListener(Pokemon pokemon, int position) {
        choosePokemonPresenter.setSelectedPokemon(pokemon);
        adapter.setSelectedPokemon(choosePokemonPresenter.getSelectedPokemon());
        continueButton.setText("Continue with " + pokemon.getName());
        continueButton.setVisibility(View.VISIBLE);
    }
}