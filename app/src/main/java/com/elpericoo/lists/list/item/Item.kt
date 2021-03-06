package com.elpericoo.lists.list.item

import java.text.SimpleDateFormat
import java.time.Instant

data class Item(
    val title: String,

    val type: ItemTypes = ItemTypes.basic,
    val check: Boolean = false,
    val creationDate: Long = Instant.now().toEpochMilli(),
    val modificationDate: Long = Instant.now().toEpochMilli(),

    val description: String? = null,
    val location: String? = null,
    val scheduledDate: Long? = null,
    val labels: List<String> = emptyList(),

    val media: String? = null,
    val list: List<SubItem> = emptyList()
) {

    fun getCreationDate(): String {
        return getFormattedDate(creationDate)
    }

    fun getFormattedDate(date: Long): String {
        val format = SimpleDateFormat("dd-MM-yyyy")
        return format.format(date)
    }
}