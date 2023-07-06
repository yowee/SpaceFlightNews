package com.myspace.spaceflightnews.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myspace.spaceflightnews.data.model.BlogModel
import com.myspace.spaceflightnews.data.remote.ApiCall
import com.myspace.spaceflightnews.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BlogFragment : Fragment() {

    @Inject
    lateinit var apiCall: ApiCall

    private lateinit var recyclerView: RecyclerView
    private lateinit var articleAdapter: ArticleAdapter
    lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = HomeFragmentBinding.inflate(inflater, container, false)

        val viewModel by viewModels<BlogViewModel>()

        if (!viewModel.isLoaded)
            viewModel.getBlogData()

        viewModel.blogLiveData.observe(viewLifecycleOwner) { blogData ->
            loadData(blogData)
        }

        return binding.root
    }

    private fun loadData(blogData: BlogModel) {
        binding.rvHomeFragment.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = BlogAdapter(requireContext(), blogData.results)
        }

    }
}