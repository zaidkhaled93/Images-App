package com.zaidkhaled.imagescatalog.di

import com.zaidkhaled.imagescatalog.data.daos.AuthRemoteDao
import com.zaidkhaled.imagescatalog.data.daos.ImagesRemoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class DaosModule {
    companion object {
        @Provides
        fun provideImagesRemoteDao(retrofit: Retrofit): ImagesRemoteDao =
            retrofit.create(ImagesRemoteDao::class.java)

        @Provides
        fun provideAuthRemoteDao(retrofit: Retrofit): AuthRemoteDao =
            retrofit.create(AuthRemoteDao::class.java)
    }
}