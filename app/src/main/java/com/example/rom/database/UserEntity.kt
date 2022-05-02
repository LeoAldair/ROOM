package com.example.rom.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TABLE_USERS)
data class UserEntity(
    @PrimaryKey val user_name: String
)

fun UserEntity.toUser() = User(
    user_name
)
