package com.elpericoo.lists.entities

import com.elpericoo.lists.list.item.ItemTypes
import com.elpericoo.lists.list.item.SubItem
import java.time.Instant

data class Note (
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
)