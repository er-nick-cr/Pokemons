package com.example.pokemons.di;

import android.content.Context;

import com.example.pokemons.data.datasource.database.DataModule;
import com.example.pokemons.data.repository.UserRepositoryImpl;
import com.example.pokemons.domain.repository.UserRepository;
import com.example.pokemons.domain.usecase.GetUserUseCase;
import com.example.pokemons.domain.usecase.GetUserUseCaseImpl;
import com.example.pokemons.domain.usecase.InsertUserUseCase;
import com.example.pokemons.domain.usecase.InsertUserUseCaseImpl;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class UserModule {

    @Provides
    public static DataModule dataModule(Context context) {
        return DataModule.getInstance(context);
    }

    @Binds
    public abstract GetUserUseCase bindGetUserUseCase(GetUserUseCaseImpl impl);

    @Binds
    public abstract InsertUserUseCase bindInsertUserUseCase(InsertUserUseCaseImpl impl);

    @Binds
    public abstract UserRepository bindUserRepository(UserRepositoryImpl impl);

}
