package com.example.newsappmvvm.adapter

import android.content.Intent
import android.net.Uri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsappmvvm.R
import com.example.newsappmvvm.data.Article
import com.example.newsappmvvm.data.NewsList
import com.squareup.picasso.Picasso
class NewsAdapter : ListAdapter<Article, NewsAdapter.NewsViewHolder>(NewsDiffUtil()) {

    class NewsViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private val newsImage = v.findViewById<ImageView>(R.id.newsImage)
        private val adapter_title = v.findViewById<TextView>(R.id.adapter_title)
        private val adapter_description = v.findViewById<TextView>(R.id.adapter_description)
        private val adapter_content = v.findViewById<TextView>(R.id.adapter_content)
        private val adapter_seeMore = v.findViewById<TextView>(R.id.adapter_seeMore)
        private val adapter_publishedDate = v.findViewById<TextView>(R.id.adapter_publishedDate)
        private val adapter_author = v.findViewById<TextView>(R.id.adapter_author)

        fun bind(article: Article) {

                Picasso.get().load(article.urlToImage).into(newsImage)


            adapter_title.text = article.title
            adapter_description.text = article.description
            adapter_content.text = article.content
            adapter_publishedDate.text=article.publishedAt
            adapter_author.text = article.author
            adapter_seeMore.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(article.url))
                adapter_content.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_list_adpater, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class NewsDiffUtil : DiffUtil.ItemCallback<Article>() {

        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }
        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }
}