package com.expotoys.feature.toys.view

import android.os.Bundle
import com.bumptech.glide.Glide
import com.expotoys.R
import com.expotoys.common.core.view.BaseFragment
import com.expotoys.feature.toys.di.featureComponent
import com.expotoys.feature.toys.presentation.ToysPresenter
import kotlinx.android.synthetic.main.view_toys.*
import org.kodein.di.generic.instance

class ToysFragment : BaseFragment(), ToysPresenter.View {
    companion object {
        fun newInstance() = ToysFragment()
    }

    private val presenter: ToysPresenter by featureComponent.instance()

    override fun onRequestLayoutResourceId(): Int = R.layout.view_toys

    override fun onViewReady(savedInstanceState: Bundle?) {
        presenter.onViewReady(this)
    }

    override fun showImage(url: String) {
        context?.let {
            Glide.with(it)
                .asBitmap()
                .load(url)
                .into(image)
        }
    }
}
