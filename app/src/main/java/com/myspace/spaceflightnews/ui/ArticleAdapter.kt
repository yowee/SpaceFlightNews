package com.myspace.spaceflightnews.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myspace.spaceflightnews.R
import com.myspace.spaceflightnews.data.model.ResultModel
import com.myspace.spaceflightnews.databinding.ItemArticleBinding

class ArticleAdapter(
    private val childFragmentManager: FragmentManager,
    val result: List<ResultModel>
) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false),
            childFragmentManager
        )
    }

    override fun getItemCount(): Int {
        return result.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        result[position].let { holder.updateUI(it) }
    }


    class ViewHolder(val view: View, private val fragmentManager: FragmentManager) :
        RecyclerView.ViewHolder(view) {
        val binding = ItemArticleBinding.bind(view)
        fun updateUI(result: ResultModel) {
            binding.apply {
                Glide.with(view)
                    .load(result.imageUrl)
                    .into(articleImageView)

                titleTextView.text = result.title
                summaryTextView.text = result.summary
                newsSiteTextView.text = result.newsSite
                publishedAtTextView.text = result.publishedAt

                readMoreButton.setOnClickListener {
                    onSelected(result)
                }
            }
        }

        fun onSelected(result: ResultModel) {
            val dialog = ArticleDetailDialog()
            val bundle = Bundle()
            bundle.putParcelable("article", result)
            dialog.arguments = bundle
            dialog.show(fragmentManager, "ArticleDetailDialog")
        }

    }

}

