package com.example.androidbirthdayparty

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidbirthdayparty.ui.invitation.InvitationScreen
import com.example.androidbirthdayparty.ui.invitation.InvitationViewModel
import kotlinx.serialization.Serializable

@Composable
fun NavGraph(
    invitationViewModel: InvitationViewModel,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val invitations = invitationViewModel.invitations.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = Route.InvitationScreen
    ) {
        composable<Route.InvitationScreen> {
            InvitationScreen(
                invitations = invitations.value,
                modifier = modifier,
                navToInvitationForm = {navController.navigate(Route.InvitationForm)}
            )
        }

        composable<Route.InvitationForm> {
            Text(text = "future invitation form")
        }
    }
}

sealed interface Route {
    @Serializable data object InvitationScreen: Route
    @Serializable data object InvitationForm: Route

}