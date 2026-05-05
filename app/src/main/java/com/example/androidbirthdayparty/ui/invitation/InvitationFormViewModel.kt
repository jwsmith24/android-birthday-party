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
): ViewModel() {

    private val _formState = MutableStateFlow(Invitation(name = "", address = ""))
    val formState = _formState.asStateFlow()

    fun handleNameFieldChange(name: String) {
        _formState.update { it.copy(name = name) }
    }

    fun handlePlusOneChange(hasPlusOne: Boolean) {
        _formState.update { it.copy(hasPlusOne = hasPlusOne) }
    }

    fun handleAddressChange(address: String) {
        _formState.update { it.copy(address = address) }
    }

    private fun invitationValid(): Boolean {
        return (_formState.value.name.isNotEmpty() && _formState.value.address.isNotEmpty())
    }

    fun handleSubmit() {
        if (invitationValid()) {
            invitationRepository.add(_formState.value)
        }
    }


}