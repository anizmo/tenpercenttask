package com.anizmocreations.tenpercenttask.adapter

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anizmocreations.tenpercenttask.R
import com.anizmocreations.tenpercenttask.adapter.callback.TopicsListCallback
import com.anizmocreations.tenpercenttask.model.Topic
import com.anizmocreations.tenpercenttask.adapter.viewholders.TopicsViewHolder

class TopicsAdapter(private val context: Context, private val topicsListCallback: TopicsListCallback)
    : RecyclerView.Adapter<TopicsViewHolder>() {

    var featuredTopics = mutableListOf<Topic>()

    fun setFeaturedTopicsList(featuredTopics: List<Topic>) {
        this.featuredTopics = featuredTopics.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicsViewHolder {
        return TopicsViewHolder(LayoutInflater.from(context)
            .inflate(R.layout.item_topic, parent,false))
    }

    override fun onBindViewHolder(holder: TopicsViewHolder, position: Int) {
        holder.title.text = featuredTopics.get(position).title
        holder.meditationsCount.text = context.getString(R.string.meditations_count,
            featuredTopics.get(position).meditations?.size.toString()
        )

        holder.parentViewTopic
            .setCardBackgroundColor(Color.parseColor(featuredTopics[position].color))

        Log.d(this.javaClass.simpleName, "Data Bind for a Viewholder")

        holder.parentViewTopic.setOnClickListener {
            topicsListCallback.onTopicClicked(featuredTopics[position])
        }
    }

    override fun getItemCount(): Int {
        return featuredTopics.size
    }
}