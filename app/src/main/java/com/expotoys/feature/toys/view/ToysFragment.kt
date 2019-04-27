package com.expotoys.feature.toys.view

import com.expotoys.common.core.view.BaseFragment

class ToysFragment : BaseFragment() {
    companion object {
        fun newInstance() = ToysFragment()
    }

    override fun onRequestLayoutResourceId(): Int = 0
}
