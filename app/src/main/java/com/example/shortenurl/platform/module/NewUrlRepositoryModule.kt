package com.example.shortenurl.platform.module

import com.example.shortenurl.api.CoreHomeApi
import com.example.shortenurl.repositories.NewUrlRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class NewUrlRepositoryModule {
    @Provides
    fun urlRepository(apiService: CoreHomeApi):
        NewUrlRepository = NewUrlRepository(apiService)
}
