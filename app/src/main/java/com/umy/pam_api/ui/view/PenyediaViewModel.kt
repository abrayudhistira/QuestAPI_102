package com.umy.pam_api.ui.view

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.umy.pam_api.application.MahasiswaApplications
import com.umy.pam_api.ui.viewmodel.HomeViewModel
import com.umy.pam_api.ui.viewmodel.InsertViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeViewModel(aplikasiKontak().container.kontakRepository) }
        initializer { InsertViewModel(aplikasiKontak().container.kontakRepository) }
    }
}

fun CreationExtras.aplikasiKontak(): MahasiswaApplications =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications)