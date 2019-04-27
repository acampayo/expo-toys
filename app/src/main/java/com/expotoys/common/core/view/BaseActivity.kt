package com.expotoys.common.core.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.attach(android.R.id.content, onRequestFragment())
        }
    }

    abstract fun onRequestFragment(): Fragment
}
