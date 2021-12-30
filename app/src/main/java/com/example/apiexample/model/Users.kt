package com.example.apiexample.model

data class Users(
    val message: String,
    val statusCode: Int,
    val user_details: UserDetails
)

data class UserDetails(
    val email: String,
    val id: Int,
    val status: Boolean,
    val token: String,
    val username: String
)