package com.example.pokemons.di;

import android.content.Context;

import com.example.pokemons.data.datasource.database.PokemonDatabase;
import com.example.pokemons.data.repository.UserRepositoryImpl;
import com.example.pokemons.domain.repository.UserRepository;
import com.example.pokemons.domain.usecase.user.GetUserUseCase;
import com.example.pokemons.domain.usecase.user.GetUserUseCaseImpl;
import com.example.pokemons.domain.usecase.user.InsertUserUseCase;
import com.example.pokemons.domain.usecase.user.InsertUserUseCaseImpl;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class UserModule {

    @Provides
    public static PokemonDatabase dataModule(Context context) {
        return PokemonDatabase.getInstance(context);
    }

    @Binds
    public abstract GetUserUseCase bindGetUserUseCase(GetUserUseCaseImpl impl);

    @Binds
    public abstract InsertUserUseCase bindInsertUserUseCase(InsertUserUseCaseImpl impl);

    @Binds
    public abstract UserRepository bindUserRepository(UserRepositoryImpl impl);

}
