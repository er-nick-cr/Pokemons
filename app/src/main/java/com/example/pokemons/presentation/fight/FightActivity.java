package com.example.pokemons.presentation.fight;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.pokemons.PokemonApplication;
import com.example.pokemons.R;
import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.presentation.fight_preview.FightPreviewActivity;
import com.example.pokemons.presentation.main_menu.MainMenuActivity;

import javax.inject.Inject;

public class FightActivity extends AppCompatActivity implements FightView {

    @Inject
    FightPresenter fightPresenter;

    private ImageView pokemonImage;
    private ImageView enemyImage;
    private TextView pokemonName;
    private TextView enemyName;
    private TextView specialAttackTitle;
    private ProgressBar pokemonHealth;
    private ProgressBar enemyHealth;
    private ImageButton attackButton;
    private ImageButton specialAttackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);

        PokemonApplication application = (PokemonApplication) getApplicationContext();
        application.getUserComponent()
                .inject(this);

        fightPresenter.attachView(this);

        pokemonImage = findViewById(R.id.pokemon_image_fight);
        enemyImage = findViewById(R.id.enemy_image_fight);
        pokemonName = findViewById(R.id.pokemon_name_fight);
        enemyName = findViewById(R.id.enemy_name_fight);
        pokemonHealth = findViewById(R.id.pokemon_health_indicator);
        enemyHealth = findViewById(R.id.enemy_health_indicator);
        attackButton = findViewById(R.id.attack_button);
        specialAttackButton = findViewById(R.id.special_attack_button);
        specialAttackTitle = findViewById(R.id.special_attack_button_title);
    }

    @Override
    protected void onStart() {
        super.onStart();

        fightPresenter.loadFighters();
    }

    @Override
    protected void onStop() {
        super.onStop();

        fightPresenter.clearDisposable();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        fightPresenter.detachView();
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
        pokemonHealth.setMax(pokemon.getHealth());
        pokemonHealth.setProgress(pokemon.getHealth());
        enemyHealth.setMax(enemy.getHealth());
        enemyHealth.setProgress(enemy.getHealth());
    }

    @Override
    public int getEnemyHealth() {
        return enemyHealth.getProgress();
    }

    @Override
    public void setEnemyHealth(int currentHealth) {
        enemyHealth.setProgress(currentHealth);
    }

    @Override
    public int getPokemonHealth() {
        return pokemonHealth.getProgress();
    }

    @Override
    public void setPokemonHealth(int currentHealth) {
        pokemonHealth.setProgress(currentHealth);
    }

    @Override
    public void onEnemyAttack(Pokemon pokemon, Pokemon enemy, int isLastEnemy) {
        attackButton.setOnClickListener((v) -> {
            fightPresenter.attackEnemy(pokemon, enemy, false, isLastEnemy);
        });

        specialAttackButton.setOnClickListener((v) -> {
            fightPresenter.attackEnemy(pokemon, enemy, true, isLastEnemy);
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(FightActivity.this, MainMenuActivity.class);
        startActivity(intent);
    }


    @Override
    public void showError() {
        Toast.makeText(FightActivity.this, R.string.name_error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void moveToFightPreviewActivity() {
        Handler handler = new Handler();
        Intent intent = new Intent(FightActivity.this, FightPreviewActivity.class);
        handler.postDelayed(() -> startActivity(intent), 3000);
    }

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    @Override
    public void setPokemonWinner() {
        pokemonName.setText("Winner!");
        pokemonName.setTextColor(getResources().getColor(R.color.text_color_main));
    }

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    @Override
    public void setEnemyWinner() {
        enemyName.setText("Winner!");
        enemyName.setTextColor(getResources().getColor(R.color.text_color_main));
    }

    @Override
    public void moveToMainMenuActivity() {
        Handler handler = new Handler();
        Intent intent = new Intent(FightActivity.this, MainMenuActivity.class);
        handler.postDelayed(() -> startActivity(intent), 3000);
    }

    @Override
    public void hideSpecialAttackButton() {
        specialAttackButton.setVisibility(View.GONE);
        specialAttackTitle.setText("Unavailable");
        specialAttackTitle.setTextColor(getResources().getColor(R.color.design_default_color_error));
    }
}