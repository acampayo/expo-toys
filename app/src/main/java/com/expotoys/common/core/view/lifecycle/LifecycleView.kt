package com.expotoys.common.core.view.lifecycle

import kotlinx.coroutines.channels.ReceiveChannel

interface LifecycleView {
  val lifecycle: ReceiveChannel<Lifecycle>

  enum class Lifecycle {
    CREATED, INITIALIZED, RESUME, PAUSE, STOP, START, DESTROYED
  }
}
