package com.haris.myskin.adapter

import android.content.Context
import android.view.View
import androidx.viewpager.widget.PagerAdapter
import com.haris.myskin.R
import android.view.ViewGroup
import android.widget.ImageView

internal class NewsViewPagerAdapter(private val ctx: Context) : PagerAdapter() {
    private val ImageArray = intArrayOf(R.drawable.news1, R.drawable.news2, R.drawable.news3)
    override fun getCount(): Int {
        return ImageArray.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(ctx)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        imageView.setImageResource(ImageArray[position])
        container.addView(imageView, 0)
        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ImageView)
    }
}