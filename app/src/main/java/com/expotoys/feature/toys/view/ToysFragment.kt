package com.expotoys.feature.toys.view

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.expotoys.R
import com.expotoys.common.core.domain.model.Toy
import com.expotoys.common.core.view.BaseFragment
import com.expotoys.feature.toys.adapter.ToysAdapter
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

    override fun renderToys(toys: List<Toy>) {
        context?.let {
            toys_list.layoutManager = GridLayoutManager(it, 2)
            toys_list.adapter = ToysAdapter(toys)
        }
    }

    override fun renderServerError(error: String) {
        //TODO: Render error
    }

    override fun showEmptyView() {
        empty_view.visibility = View.VISIBLE
    }

    override fun showLoading() {
        progress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress.visibility = View.GONE
    }
}
