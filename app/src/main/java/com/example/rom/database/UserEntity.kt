package com.example.rom.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TABLE_USERS)
data class UserEntity(
    @ColumnInfo (name = "user_id") @PrimaryKey val uuid: String,
    val user_name: String,
    val user_height: Double,
    val user_weight: Double,
    val user_email: String
)

fun UserEntity.toUser() = User(
    uuid,
    user_name,
    user_height,
    user_weight,
    user_email
)
