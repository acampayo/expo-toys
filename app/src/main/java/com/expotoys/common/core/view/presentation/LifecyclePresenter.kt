package com.expotoys.common.core.view.presentation

import com.expotoys.common.core.view.lifecycle.LifecycleView
import com.expotoys.threading.APPLICATION_BG
import com.expotoys.threading.finish
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlin.coroutines.CoroutineContext

abstract class LifecyclePresenter<T : LifecycleView> : CoroutineScope {
    protected var view: T? = null

    private val lifecycle: ReceiveChannel<LifecycleView.Lifecycle>?
        get() = view?.lifecycle

    override val coroutineContext: CoroutineContext
        get() = APPLICATION_BG + SupervisorJob()

    fun onViewReady(view: T, firstTime: Boolean = false) {
        this.view = view
        subscribeToViewLifecycle()
        onViewAttached(firstTime)
    }

    private fun subscribeToViewLifecycle() {
        async {
            lifecycle?.consumeEach {
                if (it == LifecycleView.Lifecycle.DESTROYED) {
                    onViewDestroyed()
                    view = null
                    coroutineContext.cancelChildren()
                }
            }
        }.invokeOnCompletion {
            lifecycle?.finish()
        }
    }

    protected open fun onViewAttached(firstTime: Boolean = false) { }

    protected open fun onViewDestroyed() { }

    protected fun <T> bg(execution: suspend CoroutineScope.() -> T) = async { execution() }

    protected suspend fun <T> await(block: suspend () -> T): T = withContext(coroutineContext) { block() }
}
