package com.example.pokemons.presentation.menu.recycler;

import static androidx.recyclerview.widget.RecyclerView.NO_POSITION;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pokemons.R;
import com.example.pokemons.domain.entity.Pokemon;

public class MenuViewHolder extends RecyclerView.ViewHolder {

    private final ConstraintLayout pokemonItem;
    private final ImageView pokemonImage;
    private final TextView pokemonName;
    private final TextView pokemonHealth;
    private final TextView pokemonDefence;
    private final TextView pokemonAttack;
    private final TextView pokemonSpecialAttack;


    public MenuViewHolder(
            @NonNull View itemView,
            @NonNull OnItemClickListener onItemClickListener
    ) {
        super(itemView);

        pokemonItem = itemView.findViewById(R.id.pokemon_item);
        pokemonImage = itemView.findViewById(R.id.pokemon_image);
        pokemonName = itemView.findViewById(R.id.pokemon_name);
        pokemonHealth = itemView.findViewById(R.id.pokemon_health);
        pokemonDefence = itemView.findViewById(R.id.pokemon_defence);
        pokemonAttack = itemView.findViewById(R.id.pokemon_attack);
        pokemonSpecialAttack = itemView.findViewById(R.id.pokemon_special_attack);

        pokemonItem.setOnClickListener(v -> {
            final int position = getBindingAdapterPosition();
            if (position != NO_POSITION) onItemClickListener.onItemClick(position);
        });
    }

    public void setImage(ImageView imagePlace, String url) {
        Glide.with(imagePlace)
                .load(url)
                .into(imagePlace);
    }

    public void setBackground(Pokemon pokemon, Pokemon selectedPokemon) {
        if(selectedPokemon != null) {
            if (pokemon.getId() == selectedPokemon.getId()) {
                pokemonItem.setBackgroundResource(R.drawable.rounded_corners_selected);
            } else {
                pokemonItem.setBackgroundResource(R.drawable.rounded_corners);
            }
        }

    }

    @SuppressLint("SetTextI18n")
    public void bind(Pokemon pokemon, Pokemon selectedPokemon) {
        pokemonName.setText(pokemon.getName());
        pokemonHealth.setText("Health: " + pokemon.getHealth());
        pokemonDefence.setText("Defence: " + pokemon.getDefense());
        pokemonAttack.setText("Attack:" + pokemon.getAttack());
        pokemonSpecialAttack.setText("Special Attack: " + pokemon.getSpecialAttack());
        setImage(pokemonImage, pokemon.getImageUrl());
        setBackground(pokemon, selectedPokemon);
    }
}
