package com.example.p8mysqldatainternet

import android.app.Application
import com.example.p8mysqldatainternet.repository.AppContainer
import com.example.p8mysqldatainternet.repository.MahasiswaContainer

class MahasiswaApplications:Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container=MahasiswaContainer()
    }
}