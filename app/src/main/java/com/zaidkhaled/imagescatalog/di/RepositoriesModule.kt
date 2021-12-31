package com.zaidkhaled.imagescatalog.di

import com.zaidkhaled.imagescatalog.data.daos.AuthRemoteDao
import com.zaidkhaled.imagescatalog.data.daos.ImagesRemoteDao
import com.zaidkhaled.imagescatalog.data.repositories.authRepository.AuthRepository
import com.zaidkhaled.imagescatalog.data.repositories.authRepository.AuthRepositoryImpl
import com.zaidkhaled.imagescatalog.data.repositories.imagesRepository.ImagesRepository
import com.zaidkhaled.imagescatalog.data.repositories.imagesRepository.ImagesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {
    companion object {
        @Provides
        fun provideImagesRepository(remoteDao: ImagesRemoteDao): ImagesRepository {
            return ImagesRepositoryImpl(
                remoteDao
            )
        }

        @Provides
        fun provideAuthRepository(remoteDao: AuthRemoteDao): AuthRepository {
            return AuthRepositoryImpl(
                remoteDao
            )
        }
    }
}