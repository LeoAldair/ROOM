package com.example.rom.database

class User(
    user_name: String
){
    val user_name: String = user_name

}

fun User.toEntity() = UserEntity(
        user_name
)