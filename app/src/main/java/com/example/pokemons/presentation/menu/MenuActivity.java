package com.example.pokemons.presentation.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pokemons.PokemonApplication;
import com.example.pokemons.R;
import com.example.pokemons.domain.entity.Pokemon;
import com.example.pokemons.presentation.menu.recycler.MenuAdapter;

import java.util.List;

import javax.inject.Inject;

public class MenuActivity extends AppCompatActivity implements MenuView {

    @Inject
    MenuPresenter menuPresenter;

    public MenuAdapter adapter = new MenuAdapter();
    public TextView userName;
    public ConstraintLayout progress;
    public  RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        PokemonApplication application = (PokemonApplication) getApplicationContext();
        application.getUserComponent()
                .inject(this);

        userName = findViewById(R.id.user_name);
        progress = findViewById(R.id.loader);
    }

    @Override
    protected void onStart() {
        super.onStart();

        menuPresenter.attachView(this);
        menuPresenter.loadUser();

        recyclerView = findViewById(R.id.main_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        menuPresenter.showPokemons();
    }

    @Override
    protected void onStop() {
        super.onStop();

        menuPresenter.detachView();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setUserName(String name) {
        userName.setText("Hello, " + name);
    }

    @Override
    public void showError() {
        Toast.makeText(MenuActivity.this, R.string.database_error, Toast.LENGTH_LONG).show();
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
}