package com.expotoys.feature.toys.view

import android.os.Bundle
import com.expotoys.R
import com.expotoys.common.core.view.BaseFragment
import com.expotoys.feature.toys.adapter.OptionsAdapter
import kotlinx.android.synthetic.main.view_toys_composer.*

class ToysComposerFragment : BaseFragment() {

    companion object {
        fun newInstance() = ToysComposerFragment()
    }

    override fun onRequestLayoutResourceId() = R.layout.view_toys_composer

    override fun onViewReady(savedInstanceState: Bundle?) {
        activity?.let {
            options_pager.adapter =
                OptionsAdapter(it.supportFragmentManager, listOf(getString(R.string.toys), getString(R.string.news)))
            options.setupWithViewPager(options_pager)
        }
    }
}
