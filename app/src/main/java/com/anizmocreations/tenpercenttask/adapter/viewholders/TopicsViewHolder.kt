package com.anizmocreations.tenpercenttask.adapter.viewholders

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.anizmocreations.tenpercenttask.R

/**
 * This ViewHolder represents a single cell in the Topics List.
 */
class TopicsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.topic_title)
    val meditationsCount: TextView = itemView.findViewById(R.id.meditations_count)
    val parentViewTopic: CardView = itemView.findViewById(R.id.parent_view_topic)
}