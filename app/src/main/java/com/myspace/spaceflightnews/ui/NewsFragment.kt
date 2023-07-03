package com.myspace.spaceflightnews.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myspace.spaceflightnews.data.remote.ApiCall
import com.myspace.spaceflightnews.databinding.NewsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class NewsFragment : Fragment() {

    @Inject
    lateinit var apiCall: ApiCall

    private lateinit var recyclerView: RecyclerView
    private lateinit var articleAdapter: ArticleAdapter
    lateinit var binding: NewsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = NewsFragmentBinding.inflate(inflater, container, false)

        loadData()

        return binding.root
    }

    private fun loadData() {
        CoroutineScope(Dispatchers.Main).launch {

            val result = apiCall.getSpaceFlightNews()
            binding.rvNewsArticle.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = ArticleAdapter(childFragmentManager, result.results)
            }

        }
    }
}

