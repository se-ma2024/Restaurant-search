package com.example.restaurantsearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _latitude = MutableLiveData<Double>()
    private val _logitude = MutableLiveData<Double>()

    val latitude: LiveData<Double> = _latitude
    val longitude: LiveData<Double> = _logitude

//    private val _locationData = MutableLiveData<Location>()
//    val locationData: LiveData<Location> = _locationData

    fun updateLocation(latitude: Double, longitude: Double) {
        //_locationData.postValue(location)
        _latitude.postValue(latitude)
        _logitude.postValue(longitude)
    }
}