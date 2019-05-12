package com.expotoys.feature.toys.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.expotoys.feature.toys.view.ToysFragment
import com.expotoys.feature.toys.view.ToysNewsFragment

class OptionsAdapter(
    fm: FragmentManager,
    private val titles: List<CharSequence>
) : FragmentStatePagerAdapter(fm) {

    private val mFragment1 = ToysFragment.newInstance()
    private val mFragment2 = ToysNewsFragment.newInstance()

    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            mFragment1
        } else {
            mFragment2
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

    override fun getCount(): Int {
        return titles.size
    }
}
