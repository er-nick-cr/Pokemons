package com.example.pokemons.presentation.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pokemons.PokemonApplication;
import com.example.pokemons.R;
import com.example.pokemons.presentation.menu.ChoosePokemonActivity;

import javax.inject.Inject;

public class InsertNameActivity extends AppCompatActivity implements InsertNameView {

    @Inject
    InsertNamePresenter insertNamePresenter;

    public Button enterButton;
    public EditText inputName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_name);

        PokemonApplication application = (PokemonApplication) getApplicationContext();
        application.getUserComponent()
                .inject(this);

        enterButton = findViewById(R.id.enter_button);
        inputName = findViewById(R.id.input_name);
        insertNamePresenter.attachView(this);
        enterButton.setOnClickListener(v -> insertNamePresenter.onEnterButtonClick(inputName.getText().toString()));
    }

    @Override
    protected void onStop() {
        super.onStop();

        insertNamePresenter.detachView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        insertNamePresenter.detachView();
    }

    @Override
    public void showEmptyNameFieldError() {
        Toast.makeText(InsertNameActivity.this, R.string.name_error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void moveToChoosePokemonScreen() {
        Intent intent = new Intent(InsertNameActivity.this, ChoosePokemonActivity.class);
        startActivity(intent);
    }
}