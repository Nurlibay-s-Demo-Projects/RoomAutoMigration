package uz.nurlibaydev.roomautomigration.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    @ColumnInfo("user_age", defaultValue = "0")
    val user_age: Int = 0
)