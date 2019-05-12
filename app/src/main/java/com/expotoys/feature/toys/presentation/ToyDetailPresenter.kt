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
        view.renderName(view.toy.name)
    }

    interface View: LifecycleView {
        val toy: Toy

        fun renderBigImage(imageUrl: String)
        fun renderName(name: String)
        fun showProgress()
        fun hideProgress()
    }
}
