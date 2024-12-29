package com.umy.pam_api.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.umy.pam_api.model.Mahasiswa
import com.umy.pam_api.repository.MahasiswaRepository

class InsertViewModel(private val mhs: MahasiswaRepository) : ViewModel() {
    var uiState by mutableStateOf(InsertUiState())
    private set
}

fun Mahasiswa.toUiStateMhs(): InsertUiState = InsertUiEvent(
    insertUiEvent = toInsertUiEvent()
)

fun Mahasiswa.toInsertUiEvent():InsertUiEvent = InsertUiEvent(
    nim = nim,
    nama = nama,
    alamat = alamat,
    jenisKelamin = jenisKelamin,
    kelas = kelas,
    angkatan = angkatan
)