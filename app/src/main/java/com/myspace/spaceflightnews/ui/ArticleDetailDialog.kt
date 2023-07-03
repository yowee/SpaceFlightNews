package com.myspace.spaceflightnews.ui

import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.myspace.spaceflightnews.R
import com.myspace.spaceflightnews.data.model.ResultModel

class ArticleDetailDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val article = arguments?.getParcelable<ResultModel>("article")

        val rootView =
            requireActivity().layoutInflater.inflate(R.layout.dialog_article_detail, null)

        val imageView = rootView.findViewById<ImageView>(R.id.articleImageView)
        Glide.with(this)
            .load(article?.imageUrl)
            .into(imageView)

        rootView.findViewById<TextView>(R.id.titleTextView).text = article?.title
        rootView.findViewById<TextView>(R.id.summaryTextView).text = article?.summary
        rootView.findViewById<TextView>(R.id.publishedAtTextView).text =
            "Published at: ${article?.publishedAt}"

        val dialog = AlertDialog.Builder(requireContext())
            .setView(rootView)
            .create()

        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        return dialog
    }
}
