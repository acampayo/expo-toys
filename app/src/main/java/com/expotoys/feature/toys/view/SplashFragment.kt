package com.expotoys.feature.toys.view

import android.content.Intent
import android.os.Bundle
import com.expotoys.R
import com.expotoys.common.core.view.BaseFragment
import com.expotoys.threading.bg
import kotlinx.coroutines.delay

class SplashFragment : BaseFragment() {
    companion object {
        fun newInstance() = SplashFragment()
    }

    override fun onRequestLayoutResourceId() = R.layout.view_splash

    override fun onViewReady(savedInstanceState: Bundle?) {
        bg {
            delay(1000)
            context?.let {
                val intent = Intent(it, ToysActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
