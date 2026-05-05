package com.example.androidbirthdayparty.data

data class Invitation(
    val name: String,
    val address: String,
    val hasPlusOne: Boolean = false,
    val rsvpStatus: RsvpStatus = RsvpStatus.PENDING
)