package com.expotoys.feature.toys.view

import android.support.v4.app.Fragment
import com.expotoys.common.core.view.BaseActivity

class ToysActivity: BaseActivity() {
    override fun onRequestFragment(): Fragment = ToysComposerFragment.newInstance()
}
