package com.expotoys.common.core.view

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import org.jetbrains.anko.bundleOf
import kotlin.reflect.KClass

fun FragmentManager.attach(@IdRes placeHolder: Int, fragment: Fragment) {
    val tag = getTag(fragment::class)
    beginTransaction()
        .replace(placeHolder, fragment, tag)
        .commitNowAllowingStateLoss()
}

fun <T : Fragment> T.withArguments(vararg arguments: Pair<String, Any?>): T {
    this.arguments = bundleOf(*arguments)
    return this
}

fun getTag(type: KClass<*>) = type.java.name
