package com.example.newexpert

import android.view.View
import androidx.viewpager2.widget.ViewPager2

abstract class BasePageTransformer : ViewPager2.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        val pageIndex = 0
        transformPage(page, pageIndex, position)
    }

    abstract fun transformPage(page: View?, pageIndex: Int, position: Float)

    override fun toString(): String {
        return javaClass.simpleName
    }

    companion object {

        fun isLeftPage(position: Float): Boolean {
            return position < 0
        }

        fun isRightPage(position: Float): Boolean {
            return position > 0
        }
    }
}