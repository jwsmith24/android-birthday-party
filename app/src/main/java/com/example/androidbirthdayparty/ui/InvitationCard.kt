package com.example.androidbirthdayparty.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbirthdayparty.data.Invitation
import com.example.androidbirthdayparty.data.RsvpStatus
import com.example.androidbirthdayparty.ui.theme.AndroidBirthdayPartyTheme

@Composable
fun InvitationCard(invite: Invitation) {

    val statusColor = when (invite.rsvpStatus) {
        RsvpStatus.PENDING -> Color.Yellow
        RsvpStatus.ACCEPTED -> Color.Green
        RsvpStatus.DECLINED -> Color.Red
    }
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .background(color = MaterialTheme.colorScheme.secondary, shape = RoundedCornerShape(size = 12.dp))
            .border(border = BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(12.dp))
            .padding(8.dp)

        ,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ){
        Text(text = invite.name + if (invite.hasPlusOne) " +1" else "", color = MaterialTheme.colorScheme.onSecondary)
        Row {
            Text(text = "Status: ", color = MaterialTheme.colorScheme.onSecondary)
            Text(text = invite.rsvpStatus.displayName(), color = statusColor)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CardPreview() {
    val mockInvite = Invitation(name = "test-person")
    AndroidBirthdayPartyTheme {
        InvitationCard(invite = mockInvite)
    }
}

@Composable
@Preview(showBackground = true)
fun CardPreviewWithPlusOne() {
    val mockInvite = Invitation(name = "test-person", hasPlusOne = true)

    AndroidBirthdayPartyTheme {
        InvitationCard(invite = mockInvite)
    }
}

@Composable
@Preview(showBackground = true)
fun CardPreviewAccepted() {
    val mockInvite = Invitation(name = "test-person", hasPlusOne = true, rsvpStatus = RsvpStatus.ACCEPTED)

    AndroidBirthdayPartyTheme {
        InvitationCard(invite = mockInvite)
    }
}

@Composable
@Preview(showBackground = true)
fun CardPreviewDeclined() {
    val mockInvite = Invitation(name = "test-person", hasPlusOne = true, rsvpStatus = RsvpStatus.DECLINED)

    AndroidBirthdayPartyTheme {
        InvitationCard(invite = mockInvite)
    }
}