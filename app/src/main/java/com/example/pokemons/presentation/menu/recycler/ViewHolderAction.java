package com.example.pokemons.presentation.menu.recycler;

import com.example.pokemons.domain.entity.Pokemon;

public interface ViewHolderAction {

    void onPokemonClick (Pokemon pokemon, int position);
}
