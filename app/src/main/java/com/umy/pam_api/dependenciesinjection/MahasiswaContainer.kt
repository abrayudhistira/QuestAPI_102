package com.umy.pam_api.dependenciesinjection

import com.umy.pam_api.repository.MahasiswaRepository

interface AppContainer {
    val kontakRepository : MahasiswaRepository
}

class MahasiswaContainer : AppContainer {

}