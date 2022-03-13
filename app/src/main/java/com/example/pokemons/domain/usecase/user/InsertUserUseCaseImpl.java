package com.example.pokemons.domain.usecase.user;

import androidx.annotation.NonNull;

import com.example.pokemons.domain.entity.User;
import com.example.pokemons.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

public class InsertUserUseCaseImpl implements InsertUserUseCase {

    @NonNull
    private final UserRepository userRepository;

    @Inject
    public InsertUserUseCaseImpl(@NonNull UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Completable insertUser(String name) {
       return userRepository.insertUser(new User(name));
    }
}
