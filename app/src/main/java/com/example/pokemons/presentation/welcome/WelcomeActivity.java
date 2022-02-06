package com.example.pokemons.presentation.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pokemons.PokemonApplication;
import com.example.pokemons.R;
import com.example.pokemons.presentation.menu.MenuActivity;

import javax.inject.Inject;

public class WelcomeActivity extends AppCompatActivity implements WelcomeView {

    @Inject
    WelcomePresenter welcomePresenter;

    public Button enterButton;
    public EditText inputName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterButton = findViewById(R.id.enter_button);
        inputName = findViewById(R.id.input_name);
    }

    @Override
    protected void onStart() {
        super.onStart();

        PokemonApplication application = (PokemonApplication) getApplicationContext();
        application.getUserComponent()
                .inject(this);

        welcomePresenter.attachView(this);
        enterButton.setOnClickListener(v -> welcomePresenter.onEnterButtonClick(inputName.getText().toString()));
    }

    @Override
    protected void onStop() {
        super.onStop();

        welcomePresenter.detachView();
    }

    @Override
    public void showEmptyNameFieldError() {
        Toast.makeText(WelcomeActivity.this, R.string.name_error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void moveToMenuScreen() {
        Intent intent = new Intent(WelcomeActivity.this, MenuActivity.class);
        startActivity(intent);
    }
}