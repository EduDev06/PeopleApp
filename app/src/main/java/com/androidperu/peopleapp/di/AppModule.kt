package com.androidperu.peopleapp.di

import android.app.Application
import androidx.room.Room
import com.androidperu.peopleapp.feature_users.data.repository.UserRepositoryImpl
import com.androidperu.peopleapp.feature_users.data.source.local.UserDatabase
import com.androidperu.peopleapp.feature_users.domain.repository.UserRepository
import com.androidperu.peopleapp.utils.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserDatabase(app: Application) = Room.databaseBuilder(
        app,
        UserDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideRepository(db: UserDatabase): UserRepository {
        return UserRepositoryImpl(db.userDao)
    }
}