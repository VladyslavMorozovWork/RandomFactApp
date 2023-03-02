package com.example.randomfactapp.utils

import android.view.View

const val MIN_CLICK_INTERVAL: Long = 300
fun View.onClick(code: (View?) -> Unit) {
    setOnClickListener(object : View.OnClickListener {
        private var mLastClickTime: Long = 0

        fun onSingleClick(v: View?) {
            code.invoke(v)
        }

        override fun onClick(v: View?) {
            val currentClickTime = System.currentTimeMillis()
            if ((currentClickTime - mLastClickTime) >= MIN_CLICK_INTERVAL) {
                mLastClickTime = currentClickTime
                onSingleClick(v)
            } else {
                return
            }
        }
    })
}