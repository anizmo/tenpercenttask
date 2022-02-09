package com.anizmocreations.tenpercenttask.adapter.viewholders

import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.anizmocreations.tenpercenttask.R

class TopicsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title = itemView.findViewById<TextView>(R.id.topic_title)
    val meditationsCount = itemView.findViewById<TextView>(R.id.meditations_count)
    val parentViewTopic = itemView.findViewById<CardView>(R.id.parent_view_topic)
}