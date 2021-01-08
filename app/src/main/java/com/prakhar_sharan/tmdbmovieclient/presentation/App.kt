package com.prakhar_sharan.tmdbmovieclient.presentation

import android.app.Application
import com.prakhar_sharan.tmdbmovieclient.BuildConfig
import com.prakhar_sharan.tmdbmovieclient.presentation.di.*
import com.prakhar_sharan.tmdbmovieclient.presentation.di.movie.MovieSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }


}