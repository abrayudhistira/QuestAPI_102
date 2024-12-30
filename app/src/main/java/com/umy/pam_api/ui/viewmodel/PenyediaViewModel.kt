package com.umy.pam_api.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.umy.pam_api.application.MahasiswaApplications

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(
                   MahasiswaApplications().container.kontakRepository)
        }
        initializer {
            InsertViewModel(
                MahasiswaApplications().container.kontakRepository)
        }
        initializer {
            DetailViewModel(
                createSavedStateHandle(),
                MahasiswaApplications().container.kontakRepository)
        }
        initializer {
            UpdateViewModel(
                createSavedStateHandle(),
                MahasiswaApplications().container.kontakRepository)
        }
    }
}

fun CreationExtras.MahasiswaApplications(): MahasiswaApplications =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications)