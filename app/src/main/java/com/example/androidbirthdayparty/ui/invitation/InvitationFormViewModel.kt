package com.example.androidbirthdayparty.ui.invitation

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.androidbirthdayparty.data.Invitation
import com.example.androidbirthdayparty.data.InvitationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class InvitationFormViewModel(
    private val invitationRepository: InvitationRepository
) : ViewModel() {

    private val defaultFormState = Invitation(name = "", address = "", hasPlusOne = false)
    private val _formState = MutableStateFlow(defaultFormState)
    val formState = _formState.asStateFlow()


    fun onUpdate(event: InvitationFormEvent) {
        when (event) {
            is InvitationFormEvent.NameChanged -> _formState.update { it.copy(name = event.name) }
            is InvitationFormEvent.AddressChanged -> _formState.update { it.copy(address = event.address) }
            is InvitationFormEvent.PlusOneChanged -> _formState.update { it.copy(hasPlusOne = event.hasPlusOne) }
        }
    }

    private fun invitationValid(): Boolean {
        return (_formState.value.name.isNotEmpty() && _formState.value.address.isNotEmpty())
    }

    private fun resetForm() {
        _formState.update { defaultFormState }
    }

    fun handleSubmit() {
        if (invitationValid()) {
            invitationRepository.add(_formState.value)
            resetForm()
        }

    }
}

sealed interface InvitationFormEvent {
    data class NameChanged(val name: String): InvitationFormEvent
    data class AddressChanged(val address: String): InvitationFormEvent
    data class PlusOneChanged(val hasPlusOne: Boolean): InvitationFormEvent

}