package com.umy.pam_api.ui.viewmodel

import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.umy.pam_api.model.Mahasiswa
import java.io.IOException

sealed class HomeUiState {
    data class Success(val mahasiswa: List<Mahasiswa>) : HomeUiState()
    object Error : HomeUiState()
    object Loading : HomeUiState()
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