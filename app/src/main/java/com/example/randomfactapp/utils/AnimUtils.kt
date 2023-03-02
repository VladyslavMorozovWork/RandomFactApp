package com.example.randomfactapp.utils

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import com.example.randomfactapp.R
import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.validationFieldErrorWith(context: Context, error: String) {
    this.error = error
    context.animateNotFilledRequiredFields(this)
}

fun Context.animateNotFilledRequiredFields(vararg views: View) {
    val anim = AnimationUtils.loadAnimation(this, R.anim.drag_empty_field)
    views.forEach { view -> view.startAnimation(anim) }
}