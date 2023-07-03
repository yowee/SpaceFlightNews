package com.myspace.spaceflightnews.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myspace.spaceflightnews.R
import com.myspace.spaceflightnews.data.model.ResultModelX
import com.myspace.spaceflightnews.databinding.ItemBlogBinding

class BlogAdapter(val context: Context, val results: List<ResultModelX>) :
    RecyclerView.Adapter<BlogAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_blog, parent, false), context
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        results[position].let { holder.updateUI(it) }
    }


    override fun getItemCount(): Int {
        return results.size
    }

    class ViewHolder(val view: View, val context: Context) : RecyclerView.ViewHolder(view) {
        val binding = ItemBlogBinding.bind(view)
        fun updateUI(result: ResultModelX) {
            binding.apply {

                Glide.with(view)
                    .load(result.imageUrl)
                    .into(ivpost)


                postTitleTextView.text = result.title
                postSummaryTextView.text = result.summary

                readMoreButton.setOnClickListener {
                    onSelected(result.url)
                }

            }
        }

        fun onSelected(url: String) {
            openUrl(url)
        }

        private fun openUrl(url: String) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            context.startActivity(intent)

        }


    }


}
