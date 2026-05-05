package com.example.androidbirthdayparty.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbirthdayparty.data.Invitation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun InvitationScreen(invitations: StateFlow<List<Invitation>>) {

    val invites = invitations.collectAsState()

    Column (
        modifier = Modifier
        .fillMaxSize()
            .padding(4.dp)
            .background(color = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(all = 4.dp)
            .border(border = BorderStroke(1.dp, Color.Cyan))

        ) {
            Text(text = "Android Birthday Party", style = MaterialTheme.typography.titleLarge)
        }
        LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            items(invites.value) {invite ->
                InvitationCard(invite)
            }
        }

    }

}

@Composable
@Preview(showBackground = true)
fun InvitationScreenPreview() {
    val mockInvites = listOf(
        Invitation(name = "Curt", hasPlusOne = true),
        Invitation(name = "Rob"),
        Invitation(name = "Jacob")
    )
    InvitationScreen(invitations = MutableStateFlow(mockInvites))
}