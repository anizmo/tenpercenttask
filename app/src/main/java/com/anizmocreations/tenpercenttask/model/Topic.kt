package com.anizmocreations.tenpercenttask.model

/**
 * Represents a single, it only contains the fields that are required and the rest of the fields are
 * ignored while parsing the list of topics.
 */
data class Topic(
    val uuid: String? = null,
    val title: String? = null,
    val position: Int? = null,
    val meditations: List<String>? = null,
    val featured: Boolean? = null,
    val color: String? = null,
    val description_short: String? = null
)
