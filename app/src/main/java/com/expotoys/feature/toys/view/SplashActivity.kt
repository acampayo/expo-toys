package com.expotoys.feature.toys.view

import com.expotoys.common.core.view.BaseActivity

class SplashActivity : BaseActivity() {
    override fun onRequestFragment() = SplashFragment.newInstance()
}
