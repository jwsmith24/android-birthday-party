package com.example.androidbirthdayparty.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.collections.listOf

class InvitationRepository {

    private val _invitations = MutableStateFlow(listOf<Invitation>())
    val invitations = _invitations.asStateFlow()

    fun add(invitation: Invitation) {
        _invitations.update { it + invitation }
    }
}