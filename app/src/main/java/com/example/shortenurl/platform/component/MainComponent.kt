package com.example.shortenurl.platform.component

import com.example.shortenurl.platform.module.NewUrlRepositoryModule
import com.example.shortenurl.platform.module.RepositoryModule
import com.example.shortenurl.platform.module.RetrofitModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        RetrofitModule::class,
        NewUrlRepositoryModule::class
    ]
)
interface MainComponent
