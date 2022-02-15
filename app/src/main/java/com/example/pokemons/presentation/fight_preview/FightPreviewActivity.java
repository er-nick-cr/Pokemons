package com.example.pokemons.presentation.fight_preview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pokemons.PokemonApplication;
import com.example.pokemons.R;
import com.example.pokemons.domain.entity.Pokemon;

import javax.inject.Inject;

public class FightPreviewActivity extends AppCompatActivity implements FightPreviewView {

    @Inject
    FightPreviewPresenter fightPreviewPresenter;

    private ImageView pokemonImage;
    private ImageView enemyImage;
    private TextView pokemonName;
    private TextView enemyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_preview);

        PokemonApplication application = (PokemonApplication) getApplicationContext();
        application.getUserComponent()
                .inject(this);

        pokemonImage = findViewById(R.id.pokemon_image_fight_preview);
        enemyImage = findViewById(R.id.enemy_image_fight_preview);
        pokemonName = findViewById(R.id.pokemon_name_fight_preview);
        enemyName = findViewById(R.id.enemy_name_fight_preview);
    }

    @Override
    protected void onStart() {
        super.onStart();

        fightPreviewPresenter.attachView(this);
        fightPreviewPresenter.loadFighters();
    }

    @Override
    public void showFighters(Pokemon pokemon, Pokemon enemy) {
        Glide.with(pokemonImage)
                .load(pokemon.getImageUrl())
                .into(pokemonImage);
        Glide.with(enemyImage)
                .load(enemy.getImageUrl())
                .into(enemyImage);
        pokemonName.setText(pokemon.getName());
        enemyName.setText(enemy.getName());
    }

    @Override
    public void showError() {

    }
}