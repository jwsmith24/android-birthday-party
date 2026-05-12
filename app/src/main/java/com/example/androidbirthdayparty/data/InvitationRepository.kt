package com.example.androidbirthdayparty.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.collections.listOf

class InvitationRepository {

    private val _invitations = MutableStateFlow<List<Invitation>>(listOf(
        Invitation(name = "test person", address = "place"),
        Invitation(name = "another test person", address = "new place", rsvpStatus = RsvpStatus.ACCEPTED, hasPlusOne = true),
        Invitation(name = "one more test person", address = "different place", rsvpStatus = RsvpStatus.DECLINED),

    ))
    val invitations = _invitations.asStateFlow()

    fun add(invitation: Invitation) {
        _invitations.update { it + invitation }
    }
}