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

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.pokemon_item, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.bind(pokemons.get(position));
    }

    @Override
    public int getItemCount() {
        return pokemons == null ? 0 : pokemons.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setPokemons(final @NonNull List<Pokemon> pokemons) {
        final MenuDiffCallback callback = new MenuDiffCallback(this.pokemons, pokemons);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(callback);

        this.pokemons = pokemons;
        diffResult.dispatchUpdatesTo(this);
    }
}
