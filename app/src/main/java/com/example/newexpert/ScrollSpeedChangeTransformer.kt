package com.aritaum1.transformer

import android.view.View
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.newexpert.BasePageTransformer
import com.example.newexpert.R


/**
 * Created by Jeongsu Choi on 2021-03-18.
 */
class ScrollSpeedChangeTransformer : ViewPager2.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        val memberNameTextView : TextView = page.findViewById(R.id.tv_member_name)

        if (inRange(position)) {
            if (position != 0f) {
                // 이 수식으로 인해 text 가 늦게 따라오는 효과를 낼 수 있다.
                val translationX = (page.width / PAGE_TRANSITION_SPEED) * position
                memberNameTextView.translationX = translationX
            } else {
                memberNameTextView.translationX = 0f
            }
        } else {
            memberNameTextView.translationX = 0f
        }
    }

    private fun inRange(position: Float): Boolean {
        return position <= 1.0 && position >= -1.0
    }

    companion object {
        // Int 값이 증가할수록 text 가 따라오는 속도가 늦춰진다.
        private const val PAGE_TRANSITION_SPEED : Int = 5
    }
}