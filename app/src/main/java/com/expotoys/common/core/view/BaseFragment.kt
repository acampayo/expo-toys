package com.expotoys.common.core.view

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.expotoys.common.core.view.lifecycle.LifecycleFragment

abstract class BaseFragment : LifecycleFragment() {
    private val layoutResourceId by lazy {
        onRequestLayoutResourceId()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        inflater.inflate(layoutResourceId, container, false)

    @LayoutRes
    abstract fun onRequestLayoutResourceId(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        onSetupListeners()
        onViewReady(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        onViewResumed()
    }

    open fun onSetupListeners() {}

    open fun onViewReady(savedInstanceState: Bundle?) {}

    open fun onViewResumed() { }
}
