package com.example.shortenurl.platform.module

import com.example.shortenurl.api.CoreHomeApi
import com.example.shortenurl.repositories.NewUrlRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class RepositoryModule {
    @Provides
    fun urlRepositoryProvaider(apiService: CoreHomeApi):
        NewUrlRepository = NewUrlRepository(apiService)
}
