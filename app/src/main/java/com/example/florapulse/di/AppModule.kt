package com.example.florapulse.di

import android.content.Context
import androidx.room.Room
import com.example.florapulse.data.database.AppDao
import com.example.florapulse.data.database.AppDatabase
import com.example.florapulse.data.repository.AppRepositoryImpl
import com.example.florapulse.domain.repository.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideDao(db: AppDatabase): AppDao = db.appDao()

    @Provides
    @Singleton
    fun provideRepository(impl: AppRepositoryImpl): AppRepository = impl
}
