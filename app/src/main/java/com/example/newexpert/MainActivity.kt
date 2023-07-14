package com.example.newexpert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.viewpager2.widget.ViewPager2
import com.aritaum1.transformer.ScrollSpeedChangeTransformer

class MainActivity : AppCompatActivity() {

    lateinit var newJeansViewPager2 : ViewPager2

    private val newjeansAdapter by lazy {
       NewjeansAdapter(getMembers())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newJeansViewPager2 = findViewById<ViewPager2>(R.id.viewpager2_new_jeans)

        newJeansViewPager2.apply {
            adapter = newjeansAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            setPageTransformer(ScrollSpeedChangeTransformer())
        }
    }

    private fun getMembers() : List<Member> {
        val members = arrayListOf<Member>(
            Member("Hanni", R.drawable.hanni),
            Member("Haerin", R.drawable.haerin),
            Member("Minji", R.drawable.minji),
            Member("Danielle", R.drawable.danielle),
            Member("Hyein", R.drawable.heyin),
        )
        return members
    }
}