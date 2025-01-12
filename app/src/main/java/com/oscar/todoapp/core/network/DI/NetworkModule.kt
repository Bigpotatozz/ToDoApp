package com.oscar.todoapp.core.network.DI

import com.oscar.todoapp.completedTasksScreen.data.network.CompletedTasksClient
import com.oscar.todoapp.initialScreen.data.network.InitialScreenClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun retrofitHelper(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideInitialScreenClient(retrofit: Retrofit): InitialScreenClient {
        return retrofit.create(InitialScreenClient::class.java);
    }

    @Singleton
    @Provides
    fun provideCompletedTaskClient(retrofit: Retrofit): CompletedTasksClient {
        return retrofit.create(CompletedTasksClient::class.java)
    }

}