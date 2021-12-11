package com.androidperu.peopleapp.feature_users.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val name: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    val age: Int
)
