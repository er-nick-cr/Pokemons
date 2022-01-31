package com.example.pokemons.domain.repository;

import com.example.pokemons.domain.entity.User;

public interface UserRepository {

    public User getUser();

    public void insertUser(User user);
}
