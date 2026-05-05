package com.example.androidbirthdayparty.data

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class InvitationRepositoryTest {

    private lateinit var invitationRepository: InvitationRepository

    @Before
    fun setup() {
        invitationRepository = InvitationRepository()
    }

    @Test
    fun whenAddInvitationCalled_thenInvitationAddedToList() {
        assertTrue(invitationRepository.invitations.value.isEmpty())

        invitationRepository.add(Invitation(name = "test-person"))

        assertEquals(1, invitationRepository.invitations.value.size)

    }
}