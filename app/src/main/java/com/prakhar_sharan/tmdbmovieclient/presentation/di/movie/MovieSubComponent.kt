package com.prakhar_sharan.tmdbmovieclient.presentation.di.movie

import android.app.Activity
import com.prakhar_sharan.tmdbmovieclient.presentation.MainActivity
import dagger.Subcomponent
import javax.inject.Inject

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
}