package com.example.pokemons.presentation.main_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.pokemons.PokemonApplication;
import com.example.pokemons.R;
import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.presentation.fight_preview.FightPreviewActivity;
import com.example.pokemons.presentation.welcome.InsertNameActivity;

import javax.inject.Inject;

public class MainMenuActivity extends AppCompatActivity implements MainMenuView {

    @Inject
    MainMenuPresenter mainMenuPresenter;

    private TextView userName;
    private ImageView pokemonImage;
    private TextView pokemonName;
    private TextView pokemonHealth;
    private TextView pokemonAttack;
    private TextView pokemonDefence;
    private TextView pokemonSpecialAttack;
    private Button changeAccountData;
    private Button enterArenaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);



        PokemonApplication application = (PokemonApplication) getApplicationContext();
        application.getUserComponent()
                .inject(this);

        mainMenuPresenter.attachView(this);

        userName = findViewById(R.id.user_name_data);
        pokemonImage = findViewById(R.id.pokemon_image_selected);
        pokemonName = findViewById(R.id.pokemon_name_selected);
        pokemonHealth = findViewById(R.id.pokemon_health_selected);
        pokemonAttack = findViewById(R.id.pokemon_attack_selected);
        pokemonDefence = findViewById(R.id.pokemon_defence_selected);
        pokemonSpecialAttack = findViewById(R.id.pokemon_special_attack_selected);
        changeAccountData = findViewById(R.id.change_account_button);
        enterArenaButton = findViewById(R.id.enter_arena_button);
        enterArenaButton.setOnClickListener(v -> {
            mainMenuPresenter.onEneterArenaButtonClick();
        });
        changeAccountData.setOnClickListener(v -> {
            mainMenuPresenter.changeAccountData();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        mainMenuPresenter.loadPokemon();
        mainMenuPresenter.loadUser();
    }

    @Override
    protected void onStop() {
        super.onStop();

        mainMenuPresenter.clearDisposable();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mainMenuPresenter.detachView();
    }

    @Override
    public void setUserName(String name) {
        userName.setText(name);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void showPokemon(Pokemon pokemon) {
        Glide.with(pokemonImage)
                .load(pokemon.getImageUrl())
                .into(pokemonImage);
        pokemonName.setText(pokemon.getName());
        pokemonHealth.setText("Health: " + pokemon.getHealth());
        pokemonDefence.setText("Defence: " + pokemon.getDefense());
        pokemonAttack.setText("Attack:" + pokemon.getAttack());
        pokemonSpecialAttack.setText("Special Attack: " + pokemon.getSpecialAttack());
    }

    @Override
    public void moveToInsertNameActivity() {
        Intent intent = new Intent(MainMenuActivity.this, InsertNameActivity.class);
        startActivity(intent);
    }

    @Override
    public void showError() {
        Toast.makeText(MainMenuActivity.this, R.string.name_error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void enterArena() {
        Intent intent = new Intent(MainMenuActivity.this, FightPreviewActivity.class);
        startActivity(intent);
    }
}