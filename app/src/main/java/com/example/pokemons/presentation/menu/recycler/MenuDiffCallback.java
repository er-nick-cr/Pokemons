package com.example.pokemons.presentation.menu.recycler;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.pokemons.domain.entity.Pokemon;

import java.util.List;

class MenuDiffCallback extends DiffUtil.Callback {

    private final List<Pokemon> oldList;
    private final List<Pokemon> newList;

    MenuDiffCallback(
            final @NonNull List<Pokemon> oldList,
            final @NonNull List<Pokemon> newList
    ) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getId() == newList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }
}
