package com.expotoys.feature.toys.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.expotoys.BuildConfig
import com.expotoys.R
import com.expotoys.common.core.view.BaseFragment
import kotlinx.android.synthetic.main.view_toys_news.*

class ToysNewsFragment : BaseFragment() {
    companion object {
        fun newInstance() = ToysNewsFragment()
    }

    override fun onRequestLayoutResourceId(): Int = R.layout.view_toys_news

    override fun onViewReady(savedInstanceState: Bundle?) {
        blog_button.setOnClickListener {
            val uri = Uri.parse(BuildConfig.ZONA_TOYS_URL)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}
