package com.example.androidbirthdayparty.ui.invitation

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbirthdayparty.R
import com.example.androidbirthdayparty.data.Invitation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun InvitationScreen(invitations:List<Invitation>, modifier: Modifier = Modifier) {


    Column (
        modifier = modifier
        .fillMaxSize()
            .padding(4.dp)

    ) {
        Row(modifier = modifier
            .fillMaxWidth()
            .padding(all = 4.dp)

        ) {
            Text(text = stringResource(R.string.invitation_screen_title), style = MaterialTheme.typography.titleLarge)
        }
        LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            items(invitations) {invite ->
                InvitationCard(invite)
            }
        }

    }

}

@Composable
@Preview(showBackground = true)
fun InvitationScreenPreview() {
    val mockInvites = listOf(
        Invitation(name = "Curt", hasPlusOne = true, address = "test-address"),
        Invitation(name = "Rob", address = "test-address"),
        Invitation(name = "Jacob", address = "test-address")
    )
    InvitationScreen(invitations = mockInvites)
}