package com.myspace.spaceflightnews.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myspace.spaceflightnews.data.model.SpaceflightNewsModel
import com.myspace.spaceflightnews.databinding.NewsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var articleAdapter: ArticleAdapter
    lateinit var binding: NewsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = NewsFragmentBinding.inflate(inflater, container, false)

        val viewModel by viewModels<ArticleViewModel>()

        if (!viewModel.isLoaded)
            viewModel.getArticleData()

        viewModel.articleLiveData.observe(viewLifecycleOwner) { articleData ->
            loadData(articleData)
        }

        return binding.root
    }

    private fun loadData(result: SpaceflightNewsModel) {

        binding.rvNewsArticle.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ArticleAdapter(childFragmentManager, result.results)
        }

    }
}

