package com.expotoys.feature.toys.view

import android.support.v4.app.Fragment
import com.expotoys.common.core.domain.model.Toy
import com.expotoys.common.core.view.BaseActivity

class ToyDetailActivity: BaseActivity() {
    companion object {
        const val TOY_EXTRA = "toy_extra"
    }

    private val toy: Toy
        get() = intent.getParcelableExtra(TOY_EXTRA) ?:
            throw IllegalArgumentException("The Trip ID parameter can't be null.")

    override fun onRequestFragment(): Fragment = ToyDetailFragment.newInstance(toy)
}
