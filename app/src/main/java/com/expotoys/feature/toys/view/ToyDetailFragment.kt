package com.expotoys.feature.toys.view

import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.expotoys.R
import com.expotoys.common.core.domain.model.Toy
import com.expotoys.common.core.view.BaseFragment
import com.expotoys.common.core.view.withArguments
import com.expotoys.feature.toys.di.featureComponent
import com.expotoys.feature.toys.presentation.ToyDetailPresenter
import kotlinx.android.synthetic.main.view_toy_detail.*
import kotlinx.android.synthetic.main.view_toy_detail_container.*
import org.kodein.di.generic.instance

class ToyDetailFragment: BaseFragment(), ToyDetailPresenter.View {

    companion object {
        fun newInstance(toy: Toy) = ToyDetailFragment().withArguments(
            ToyDetailActivity.TOY_EXTRA to toy
        )
    }

    private val presenter: ToyDetailPresenter by featureComponent.instance()

    override val toy: Toy
        get() = arguments?.getParcelable(ToyDetailActivity.TOY_EXTRA)
            ?: throw IllegalArgumentException("The ID parameter can not be null.")

    override fun onRequestLayoutResourceId(): Int = R.layout.view_toy_detail_container

    override fun onViewReady(savedInstanceState: Bundle?) {
        presenter.onViewReady(this)
    }

    override fun renderBigImage(imageUrl: String) {
        context?.let { context ->
            Glide.with(context)
                .load(imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(toy_big_image)
        }
    }

    override fun renderName(name: String) {
        this.name.text = name
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
