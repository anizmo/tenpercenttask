package com.anizmocreations.tenpercenttask.model

/**
 * Represents the response class that wraps the topics list. The response of the topics API call is
 * obtained in this form of object, it is parsed using the Gson parser from Json to Kotlin Data
 * class.
 */
data class TopicResponse(var topics: List<Topic>? = null)