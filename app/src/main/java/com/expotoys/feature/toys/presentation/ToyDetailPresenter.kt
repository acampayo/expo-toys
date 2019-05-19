package com.expotoys.feature.toys.presentation

import com.expotoys.common.core.domain.model.Toy
import com.expotoys.common.core.view.lifecycle.LifecycleView
import com.expotoys.common.core.view.presentation.LifecyclePresenter

class ToyDetailPresenter: LifecyclePresenter<ToyDetailPresenter.View>() {

    override fun onViewAttached(firstTime: Boolean) {
        view?.let {
            loadToyDetail(it)
        }
    }

    private fun loadToyDetail(view: View) {
        val photos = view.toy.photos
        if (photos.isNotEmpty()) {
            view.renderBigImage(photos.first())
        }
        view.setupActionBar(view.toy.artist)
        view.renderName(view.toy.name)
        view.renderDescription(view.toy.description)
        view.renderBiography(view.toy.biography)
        view.renderTechnique(view.toy.technique)
        view.renderSize(view.toy.size)
        view.renderInstagramUrl(view.toy.instagramUrl, view.toy.instagramUser)
        view.renderPhotos(view.toy.photos)
    }

    interface View: LifecycleView {
        val toy: Toy

        fun renderBigImage(imageUrl: String)
        fun setupActionBar(artistName: String)
        fun renderName(name: String)
        fun renderDescription(description: String)
        fun renderBiography(biography: String)
        fun renderTechnique(technique: String)
        fun renderSize(size: String)
        fun renderInstagramUrl(instagramUrl: String, instagramUser: String)
        fun renderPhotos(photos: List<String>)
    }
}
