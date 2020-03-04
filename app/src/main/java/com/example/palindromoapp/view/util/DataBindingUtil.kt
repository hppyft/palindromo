package com.example.palindromoapp.view.util

import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.example.palindromoapp.R


@BindingAdapter("palindromoText")
fun setPalindromoText(tv: AppCompatTextView, isPalindromo: Boolean) {
    tv.text =
        if (isPalindromo) tv.context.getString(R.string.success_short_answer) else tv.context.getString(
            R.string.failure_short_answer
        )
}