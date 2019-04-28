package com.expotoys.feature.toys.presentation

import com.expotoys.common.core.data.repository.toy.ToysRepository
import com.expotoys.common.core.domain.model.Toy
import com.expotoys.common.core.view.lifecycle.LifecycleView
import com.expotoys.common.core.view.presentation.LifecyclePresenter
import com.expotoys.threading.onCompletion
import com.expotoys.threading.perform

class ToysPresenter(
    private val repository: ToysRepository
): LifecyclePresenter<ToysPresenter.View>() {
    override fun onViewAttached(firstTime: Boolean) {
        loadToys()
    }

    private fun loadToys() {
        view?.showLoading()
        bg {
            repository.getToys().onSuccess { toys ->
                perform {
                    if (toys.isEmpty()) {
                        view?.showEmptyView()
                    } else {
                        view?.renderToys(toys)
                    }
                }
            }.onFailure {
                print("Error getting toys")
                perform {
                    view?.renderServerError(it.message.orEmpty())
                    view?.showEmptyView()
                }
            }
        }.onCompletion {
            perform { view?.hideLoading() }
        }
    }

    interface View : LifecycleView {
        fun renderToys(toys: List<Toy>)
        fun renderServerError(error: String)
        fun showEmptyView()
        fun showLoading()
        fun hideLoading()
    }
}
