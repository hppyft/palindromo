package com.example.palindromoapp.view.util

import android.text.TextWatcher

interface AfterTextChangedListener: TextWatcher {

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        //do nothing
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        //do nothing
    }
}