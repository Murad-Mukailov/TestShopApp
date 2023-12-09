package com.example.testshopapp.auth.domain.model

data class Account(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String
) {
    fun toAccount(): Account = Account(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email
    )
}
