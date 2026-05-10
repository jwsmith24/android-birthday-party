package com.example.androidbirthdayparty

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidbirthdayparty.ui.invitation.InvitationFormScreen
import com.example.androidbirthdayparty.ui.invitation.InvitationFormViewModel
import com.example.androidbirthdayparty.ui.invitation.InvitationScreen
import com.example.androidbirthdayparty.ui.invitation.InvitationViewModel
import kotlinx.serialization.Serializable

@Composable
fun NavGraph(
    invitationViewModel: InvitationViewModel,
    invitationFormViewModel: InvitationFormViewModel,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val invitations = invitationViewModel.invitations.collectAsStateWithLifecycle()
    val formState = invitationFormViewModel.formState.collectAsStateWithLifecycle()

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
            InvitationFormScreen(
                modifier = modifier,
                formState = formState.value,
                handleSubmit = invitationFormViewModel::handleSubmit,
                onUpdate = invitationFormViewModel::onUpdate,
                navToInvitationScreen = {navController.navigate(Route.InvitationScreen)}
            )
        }
    }
}

sealed interface Route {
    @Serializable data object InvitationScreen: Route
    @Serializable data object InvitationForm: Route

}