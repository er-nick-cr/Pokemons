package com.example.pokemons.presentation.menu.recycler;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemons.R;
import com.example.pokemons.domain.entity.Pokemon;

import java.util.Collections;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {

    private List<Pokemon> pokemons = Collections.emptyList();
    private final ViewHolderAction viewHolderAction;
    private Pokemon selectedPokemon;
    private int position;

    public MenuAdapter(final @NonNull ViewHolderAction viewHolderAction) {
        this.viewHolderAction = viewHolderAction;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.pokemon_item, parent, false);
        return new MenuViewHolder(view, this::onItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.bind(pokemons.get(position), selectedPokemon);
    }

    @Override
    public int getItemCount() {
        return pokemons == null ? 0 : pokemons.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setPokemons(final @NonNull List<Pokemon> pokemons) {
        final MenuDiffCallback callback = new MenuDiffCallback(this.pokemons, pokemons, selectedPokemon);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(callback);
        this.pokemons = pokemons;
        diffResult.dispatchUpdatesTo(this);
    }

    public void setSelectedPokemon(Pokemon pokemon) {
        this.selectedPokemon = pokemon;
    }

    private void onItemClick(final int position) {
       viewHolderAction.onPokemonClick(pokemons.get(position), position);
       notifyItemChanged(this.position);
       notifyItemChanged(position);
       this.position = position;
    }
}
