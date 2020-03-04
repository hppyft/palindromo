package com.example.palindromoapp.view

import android.app.Application

class PalindromoApplication : Application() {

    companion object {
        lateinit var instance: PalindromoApplication
            private set
    }

    init {
        instance = this
    }
}