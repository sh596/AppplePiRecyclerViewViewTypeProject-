package com.example.recyclerviewproject.model

data class MemoItem (
    val title: String,
    val description:String
):Item {
    override val viewType: Int
        get() = MemoItem::class.hashCode()
}
