package com.expotoys.feature.toys.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.expotoys.R
import com.expotoys.common.core.domain.model.Toy
import com.expotoys.common.core.view.BaseFragment
import com.expotoys.common.core.view.withArguments
import com.expotoys.feature.toys.adapter.ToysDetailAdapter
import com.expotoys.feature.toys.di.featureComponent
import com.expotoys.feature.toys.presentation.ToyDetailPresenter
import kotlinx.android.synthetic.main.view_toy_detail.*
import kotlinx.android.synthetic.main.view_toy_detail_container.*
import org.kodein.di.generic.instance

class ToyDetailFragment : BaseFragment(), ToyDetailPresenter.View {

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

    override fun setupActionBar(artistName: String) {
        activity?.let {
            toolbar.title = artistName
            (it as AppCompatActivity).setSupportActionBar(toolbar)
            it.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            toolbar.setNavigationOnClickListener { activity?.finish() }
        }
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

    override fun renderTechnique(technique: String) {
        this.technique.text = technique
    }

    @SuppressLint("SetTextI18n")
    override fun renderTotalPrice(totalPrice: Double) {
        this.total_price.text = totalPrice.toString() + "€"
    }

    override fun renderDescription(description: String) {
        this.description.text = description
    }

    override fun renderBiography(biography: String) {
        this.biography.text = biography
    }

    override fun renderSize(size: String) {
        this.size.text = size
    }

    override fun renderInstagramUrl(instagramUrl: String, instagramUser: String) {
        this.instagramUrl.text = instagramUser
    }

    override fun renderPhotos(photos: List<String>) {
        context?.let {
            this.photos.layoutManager = LinearLayoutManager(it, LinearLayoutManager.VERTICAL, false)
            this.photos.adapter = ToysDetailAdapter(toy.photos)
        }
    }
}
