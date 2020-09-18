package com.example.clase_8__lunes_15092020

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.clase_8__lunes_15092020.model.Repository
import com.example.clase_8__lunes_15092020.model.Terrain

class MarsViewModel : ViewModel() {
    // una variable referencia al repositorio
    private val repository = Repository()

    init {
        // indica el metodo que traera el val repositorio
        repository.getDataFromServer()
    }

    fun exposeLiveDataFromServer(): LiveData<List<Terrain>> {
        return repository.mLiveData
    }

}