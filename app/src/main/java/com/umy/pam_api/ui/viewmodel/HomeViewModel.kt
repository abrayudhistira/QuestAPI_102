package com.umy.pam_api.ui.viewmodel

import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import java.io.IOException

sealed class HomeUiState {

}

fun deleteMhs(nim:String) {
    viewModelScope.launch {
        try {
            mhs.deleteMahasiswa(nim)
        }catch(e:IOException){
            HomeUiState.Error
        }catch (e:HttpException) {
            HomeUiState.Error
        }
    }
}