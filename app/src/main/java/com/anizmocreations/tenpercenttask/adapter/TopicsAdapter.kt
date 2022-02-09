package com.anizmocreations.tenpercenttask.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.anizmocreations.tenpercenttask.R
import com.anizmocreations.tenpercenttask.adapter.callback.TopicsListCallback
import com.anizmocreations.tenpercenttask.adapter.viewholders.TopicsViewHolder
import com.anizmocreations.tenpercenttask.model.Topic

/**
 * The adapter class that binds the list of topics to the recyclerview.
 *
 * @param context - The activity context required for accessing the resources.
 * @param topicsListCallback - Instance of the activity or fragment that implements the callback
 *                              actions of the RecyclerView.
 */
class TopicsAdapter(
    private val context: Context,
    private val topicsListCallback: TopicsListCallback,
    private val featuredTopics: List<Topic>
) : RecyclerView.Adapter<TopicsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicsViewHolder {
        return TopicsViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_topic, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TopicsViewHolder, position: Int) {
        holder.title.text = featuredTopics.get(position).title
        holder.meditationsCount.text = context.getString(
            R.string.meditations_count,
            featuredTopics[position].meditations?.size.toString()
        )

        if (featuredTopics[position].color.isNullOrEmpty()) {
            holder.parentViewTopic
                .setCardBackgroundColor(ContextCompat.getColor(context, R.color.purple_200))
        } else {
            holder.parentViewTopic
                .setCardBackgroundColor(Color.parseColor(featuredTopics[position].color))
        }

        holder.parentViewTopic.setOnClickListener {
            topicsListCallback.onTopicClicked(featuredTopics[position])
        }
    }

    override fun getItemCount(): Int {
        return featuredTopics.size
    }
}