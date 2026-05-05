package com.example.androidbirthdayparty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidbirthdayparty.data.InvitationRepository
import com.example.androidbirthdayparty.ui.invitation.InvitationViewModel
import com.example.androidbirthdayparty.ui.theme.AndroidBirthdayPartyTheme

class MainActivity : ComponentActivity() {

    private lateinit var invitationRepository: InvitationRepository
    private lateinit var invitationViewModel: InvitationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()

        enableEdgeToEdge()
        setContent {
            AndroidBirthdayPartyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavGraph(invitationViewModel = invitationViewModel, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

    private fun init() {
        invitationRepository = InvitationRepository()
        invitationViewModel = InvitationViewModel(invitationRepository)

    }
}