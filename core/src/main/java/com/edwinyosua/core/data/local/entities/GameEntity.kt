package com.edwinyosua.core.data.local.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity("game_table")
data class GameEntity(

    @PrimaryKey
    val id: String,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("rating")
    val rating: Double,
    @ColumnInfo("backgroundImg")
    val backgroundImg: String,
    @ColumnInfo("description")
    val description: String? = "",
    @ColumnInfo("favorite")
    val isFavorite: Boolean? = false

) : Parcelable