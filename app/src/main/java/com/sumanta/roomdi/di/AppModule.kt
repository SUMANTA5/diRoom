package com.sumanta.roomdi.di

import android.content.Context
import androidx.room.Room
import com.sumanta.roomdi.dao.UserDao
import com.sumanta.roomdi.repo.UserRepository
import com.sumanta.roomdi.userdatabase.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): UserDatabase =
        Room.databaseBuilder(context,UserDatabase::class.java,"userDatabase")
            .build()

    @Provides
    fun providesUserDao(userDatabase: UserDatabase):UserDao = userDatabase.userDao()

    @Provides
    fun providesUserRepo(userDao: UserDao): UserRepository =
        UserRepository(userDao)
}