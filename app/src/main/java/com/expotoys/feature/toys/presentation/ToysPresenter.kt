package com.expotoys.feature.toys.presentation

import com.expotoys.common.core.data.repository.toy.ToysRepository
import com.expotoys.common.core.domain.model.Toy
import com.expotoys.common.core.view.lifecycle.LifecycleView
import com.expotoys.common.core.view.presentation.LifecyclePresenter
import com.expotoys.threading.perform

class ToysPresenter(
    private val repository: ToysRepository
): LifecyclePresenter<ToysPresenter.View>() {
    override fun onViewAttached(firstTime: Boolean) {
        loadToys()
    }

    private fun loadToys() {
        bg {
            repository.getToys().onSuccess { toys ->
                perform {
                    view?.renderToys(toys)
                }
            }.onFailure {
                print("Error loading toys")
                //TODO: Error control
            }
        }
    }

    interface View : LifecycleView {
        fun renderToys(toys: List<Toy>)
    }
}
