package com.edwinyosua.mobilegamestore.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.ui.GameListAdapter
import com.edwinyosua.mobilegamestore.base.BaseFragment
import com.edwinyosua.mobilegamestore.databinding.FragmentHomeBinding
import com.edwinyosua.mobilegamestore.ui.detail.DetailActivity
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
                    is ApiResponse.Empty -> {}
                    is ApiResponse.Error -> {}
                    is ApiResponse.Loading -> {}
                    is ApiResponse.Success -> {
                        gameListAdapter.submitList(gameList.data)
                        with(binding.rvGame) {
                            layoutManager = LinearLayoutManager(context)
                            setHasFixedSize(true)
                            adapter = gameListAdapter
                        }
                    }
                }
            }
        }
    }

    override fun initProcess() {}

    override fun initAction() {}

    override fun initUi() {}

    override fun initIntent() {
        gameListAdapter.onItemClick = { selectedData ->
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }
    }

}