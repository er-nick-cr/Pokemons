package com.example.pokemons.presentation.fight_preview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.pokemons.PokemonApplication;
import com.example.pokemons.R;
import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.presentation.fight.FightActivity;

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

        fightPreviewPresenter.attachView(this);

        pokemonImage = findViewById(R.id.pokemon_image_fight_preview);
        enemyImage = findViewById(R.id.enemy_image_fight_preview);
        pokemonName = findViewById(R.id.pokemon_name_fight_preview);
        enemyName = findViewById(R.id.enemy_name_fight_preview);
    }

    @Override
    protected void onStart() {
        super.onStart();

        fightPreviewPresenter.loadFighters();
        fightPreviewPresenter.startFight();
    }

    @Override
    protected void onStop() {
        super.onStop();

        fightPreviewPresenter.clearDisposable();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        fightPreviewPresenter.detachView();
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
    public void moveToFight() {
        Handler handler = new Handler();
        Intent intent = new Intent(FightPreviewActivity.this, FightActivity.class);
        handler.postDelayed(() -> startActivity(intent), 3000);
    }

    @Override
    public void showError() {
        Toast.makeText(FightPreviewActivity.this, R.string.name_error, Toast.LENGTH_LONG).show();
    }
}