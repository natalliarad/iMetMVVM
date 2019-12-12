package com.natallia.radaman.imed.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class People(
    var name: String = "",
    var metAt: String = "",
    var contact: String = "",
    var email: String = "",
    var facebook: String = "",
    var linkedIn: String = "",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)
