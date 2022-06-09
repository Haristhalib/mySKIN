package com.haris.myskin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.haris.myskin.R

/**
 * A simple [Fragment] subclass.
 * Use the [OnboardingFragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class OnboardingFragment1 : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding1, container, false)
    }
}