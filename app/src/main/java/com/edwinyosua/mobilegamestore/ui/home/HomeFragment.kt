package com.edwinyosua.mobilegamestore.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.ui.GameListAdapter
import com.edwinyosua.mobilegamestore.base.BaseFragment
import com.edwinyosua.mobilegamestore.databinding.FragmentHomeBinding
import org.koin.android.ext.android.inject

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel by inject()
    private val gameListAdapter: GameListAdapter by inject()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

    override fun initObserver() {

        homeViewModel.gameList.observe(viewLifecycleOwner) { gameList ->
            if (gameList != null) {
                when (gameList) {
                    ApiResponse.Empty -> {}
                    is ApiResponse.Error -> {}
                    ApiResponse.Loading -> {}
                    is ApiResponse.Success -> gameListAdapter.submitList(gameList.data)
                }
            }
        }
    }

    override fun initProcess() {}

    override fun initAction() {}

    override fun initUi() {
        with(binding.rvGame) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = gameListAdapter
        }
    }

    override fun initIntent() {}

}