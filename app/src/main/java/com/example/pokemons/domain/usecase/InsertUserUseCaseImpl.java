package com.example.pokemons.domain.usecase;

import androidx.annotation.NonNull;

import com.example.pokemons.domain.entity.User;
import com.example.pokemons.domain.repository.UserRepository;

import javax.inject.Inject;

public class InsertUserUseCaseImpl implements InsertUserUseCase {

    @NonNull
    private final UserRepository userRepository;

    @Inject
    public InsertUserUseCaseImpl(@NonNull UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void insertUser(User user) {
        userRepository.insertUser(user);
    }
}
