package com.anizmocreations.tenpercenttask.model

/**
 *
 */
data class Topic(val uuid: String? = null, val title: String? = null, val position: Int? = null,
                 val meditations: List<String>? = null, val featured: Boolean? = null,
                 val color: String? = null, val description_short: String? = null)
