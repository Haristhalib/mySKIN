package com.haris.myskin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.haris.myskin.R
import com.haris.myskin.adapter.ViewPagerAdapter

class OnboardingFragment : BaseFragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var viewPagerIndicator: LinearLayout
    private lateinit var skipButton: ExtendedFloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_onboarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        initViews(view)
        initListeners()
    }

    private fun initViews(view: View) {
        viewPager = view.findViewById(R.id.viewPager)
        viewPager.adapter = ViewPagerAdapter(activity as AppCompatActivity)
        viewPagerIndicator = view.findViewById(R.id.viewPagerIndicator)
        initIndicators()
        skipButton = view.findViewById(R.id.floatingActionButton)
    }

    private fun initListeners() {
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                setSelectedIndicator(position)
                when (position) {
                    1 -> {
                        skipButton.visibility = View.GONE
                    }
                    2 -> {
                        skipButton.text = "Proceed"
                        skipButton.setBackgroundColor(resources.getColor(R.color.blue_button))
                        skipButton.visibility = View.VISIBLE
                    }
                }
                super.onPageSelected(position)
            }
        })

        skipButton.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingactivity_to_newsactivity)
        }
    }

    private fun initIndicators() {
        val indicators = arrayOfNulls<View>(3)
        val layoutParamsFirst: LinearLayout.LayoutParams = LinearLayout.LayoutParams(48, 48)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(30, 30)
        layoutParams.marginEnd = 16
        layoutParamsFirst.marginEnd = 16

        for (i in indicators.indices) {
            indicators[i] = View(activity)
            if (i == 0) {
                indicators[i]?.background =
                    ResourcesCompat.getDrawable(resources, R.drawable.indicator_active, null)
                indicators[i]?.layoutParams = layoutParamsFirst
            } else {
                indicators[i]?.background =
                    ResourcesCompat.getDrawable(resources, R.drawable.indicator_inactive, null)
                indicators[i]?.layoutParams = layoutParams
            }
            viewPagerIndicator.addView(indicators[i])
        }
    }

    private fun setSelectedIndicator(position: Int) {
        for (i in 0 until viewPagerIndicator.childCount) {
            val indicator: View = viewPagerIndicator.getChildAt(i)
            if (i == position) {
                val layoutParamsSelected: LinearLayout.LayoutParams =
                    LinearLayout.LayoutParams(48, 48)
                layoutParamsSelected.marginEnd = 16
                indicator.layoutParams = layoutParamsSelected
                indicator.background =
                    ResourcesCompat.getDrawable(resources, R.drawable.indicator_active, null)
            } else {
                val layoutParamsInactive: LinearLayout.LayoutParams =
                    LinearLayout.LayoutParams(30, 30)
                layoutParamsInactive.marginEnd = 16
                indicator.layoutParams = layoutParamsInactive
                indicator.background =
                    ResourcesCompat.getDrawable(resources, R.drawable.indicator_inactive, null)
            }
        }
    }

}

