package com.anizmocreations.tenpercenttask.adapter.callback

import com.anizmocreations.tenpercenttask.model.Topic

/**
 * This is used to get a callback of the click events from the topics recyclerview.
 */
interface TopicsListCallback {

    /**
     * @param topic - The topic object corresponding to the position of the list clicked.
     */
    fun onTopicClicked(topic: Topic)

}