package com.example.pokemons.domain.usecase;

import androidx.annotation.NonNull;

import com.example.pokemons.domain.entity.User;
import com.example.pokemons.domain.repository.UserRepository;

import javax.inject.Inject;

public class GetUserUseCaseImpl implements GetUserUseCase {

    @NonNull
    private final UserRepository userRepository;

    @Inject
    public GetUserUseCaseImpl(@NonNull UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser() {
        return userRepository.getUser();
    }
}
