package com.example.palindromoapp.view.util

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.palindromoapp.view.view.HomeActivity
import com.example.palindromoapp.view.viewmodel.HomeViewModel

object ViewModelFactory {

    fun getViewModel(activity: AppCompatActivity): ViewModel {
        if (activity is HomeActivity) return ViewModelProvider(activity).get(HomeViewModel::class.java)
        throw Exception("A activity usada nao possui um viewModel listado")
    }
}