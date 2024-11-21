package com.edwinyosua.mobilegamestore.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.edwinyosua.mobilegamestore.base.BaseFragment
import com.edwinyosua.mobilegamestore.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

    override fun initObserver() {
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        homeViewModel.text.observe(viewLifecycleOwner) {
            binding.textHome.text = it
        }
    }

    override fun initProcess() {}

    override fun initAction() {}

    override fun initUi() {}

    override fun initIntent() {}

}