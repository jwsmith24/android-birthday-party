package com.example.androidbirthdayparty.ui.invitation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbirthdayparty.R
import com.example.androidbirthdayparty.data.Invitation
import com.example.androidbirthdayparty.data.RsvpStatus
import com.example.androidbirthdayparty.ui.theme.AndroidBirthdayPartyTheme

@Composable
fun InvitationCard(invite: Invitation, modifier: Modifier = Modifier) {

    val statusColor = when (invite.rsvpStatus) {
        RsvpStatus.PENDING -> Color.Yellow
        RsvpStatus.ACCEPTED -> Color.Green
        RsvpStatus.DECLINED -> Color.Red
    }
    Card(
        modifier = modifier.fillMaxWidth().padding(4.dp)


    ) {
        Row(
            modifier = modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = invite.name + if (invite.hasPlusOne) stringResource(R.string.plus_one) else "",
                )
                Text(
                    text = invite.address, fontStyle = FontStyle.Italic
                )
            }
            Row {
                Text(text = stringResource(R.string.rsvp_status) + " ")
                Text(text = invite.rsvpStatus.displayName(), color = statusColor)
            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun CardPreview() {
    val mockInvite = Invitation(name = "test-person", address = "test-address")
    AndroidBirthdayPartyTheme {
        InvitationCard(invite = mockInvite)
    }
}

@Composable
@Preview(showBackground = true)
fun CardPreviewWithPlusOne() {
    val mockInvite = Invitation(name = "test-person", hasPlusOne = true, address = "test-address")

    AndroidBirthdayPartyTheme {
        InvitationCard(invite = mockInvite)
    }
}

@Composable
@Preview(showBackground = true)
fun CardPreviewAccepted() {
    val mockInvite =
        Invitation(name = "test-person", hasPlusOne = true, rsvpStatus = RsvpStatus.ACCEPTED, address = "test-address")

    AndroidBirthdayPartyTheme {
        InvitationCard(invite = mockInvite)
    }
}

@Composable
@Preview(showBackground = true)
fun CardPreviewDeclined() {
    val mockInvite =
        Invitation(name = "test-person", hasPlusOne = true, rsvpStatus = RsvpStatus.DECLINED, address = "test-address")

    AndroidBirthdayPartyTheme {
        InvitationCard(invite = mockInvite)
    }
}