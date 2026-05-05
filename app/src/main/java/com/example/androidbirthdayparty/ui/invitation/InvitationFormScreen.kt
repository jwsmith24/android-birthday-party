package com.example.androidbirthdayparty.ui.invitation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbirthdayparty.data.Invitation


@Composable
fun InvitationFormScreen(
    modifier: Modifier = Modifier,
    formState: Invitation,
    handleNameFieldChange: (String) -> Unit,
    handleAddressFieldChange: (String) -> Unit,
    handlePlusOneChange: (Boolean) -> Unit,
    handleSubmit: () -> Unit,
    navToInvitationScreen: () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        OutlinedTextField(
            value = formState.name,
            label = { Text(text = "name") },
            onValueChange = handleNameFieldChange,
            modifier = Modifier.fillMaxWidth().padding(10.dp).testTag("inputName"),
        )

        OutlinedTextField(
            value = formState.address,
            label = { Text(text = "address") },
            onValueChange = handleAddressFieldChange,
            modifier = Modifier.fillMaxWidth().padding(10.dp).testTag("inputAddress"),
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = formState.hasPlusOne,
                onCheckedChange = handlePlusOneChange,
                modifier = Modifier.testTag("checkboxPlusOne")
            )
            Text("Bringing plus one")
        }

        Button(onClick = {
            handleSubmit()
            navToInvitationScreen()
        }) {
            Text(text = "Submit")
        }
    }

}

@Composable
@Preview(showBackground = true)
fun InvitationFormPreview() {
    val mockInvitation = Invitation(name = "test", address = "test")
    InvitationFormScreen(
        formState = mockInvitation,
        handleSubmit = {},
        handleNameFieldChange = {},
        handleAddressFieldChange = {},
        handlePlusOneChange = {},
        navToInvitationScreen = {}
    )
}