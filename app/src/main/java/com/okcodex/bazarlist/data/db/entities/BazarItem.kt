package com.okcodex.bazarlist.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "bazar_item")
data class BazarItem(
    var name:String,
    var  amount: Int
) {
    @PrimaryKey( autoGenerate = true)
    var id: Int = 0
}
