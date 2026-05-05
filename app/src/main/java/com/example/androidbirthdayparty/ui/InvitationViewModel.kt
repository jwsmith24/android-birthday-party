package com.example.androidbirthdayparty.ui

import androidx.lifecycle.ViewModel
import com.example.androidbirthdayparty.data.Invitation
import com.example.androidbirthdayparty.data.InvitationRepository
import kotlinx.coroutines.flow.StateFlow

class InvitationViewModel (private val invitationRepository: InvitationRepository): ViewModel() {

    val invitations: StateFlow<List<Invitation>> = invitationRepository.invitations

}