package com.example.p8mysqldatainternet.ui.ViewModel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.p8mysqldatainternet.MahasiswaApplications

object PenyediaViewModel{
    val Factory = viewModelFactory {
        initializer { HomeViewModel(MahasiswaApplications().container.mahasiswaRepository) }
        initializer { InsertViewModel(MahasiswaApplications().container.mahasiswaRepository) }
        initializer { DetailViewModel(MahasiswaApplications().container.mahasiswaRepository) }
        initializer { UpdateViewModel(MahasiswaApplications().container.mahasiswaRepository) }
    }
    fun CreationExtras.MahasiswaApplications(): MahasiswaApplications=
        (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]as MahasiswaApplications)
}