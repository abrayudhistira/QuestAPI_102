package com.umy.pam_api.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.umy.pam_api.model.Mahasiswa
import com.umy.pam_api.repository.MahasiswaRepository
import java.io.IOException

sealed class HomeUiState {
    data class Success(val mahasiswa: List<Mahasiswa>) : HomeUiState()
    object Error : HomeUiState()
    object Loading : HomeUiState()
}

class HomeViewModel (private val mhs: MahasiswaRepository): ViewModel(){
    var mhsUiState : HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getMhs()
    }
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