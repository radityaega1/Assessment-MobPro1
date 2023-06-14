package org.d3if0103.assessment.ui.tentang

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0103.assessment.model.TentangConverter
import org.d3if0103.assessment.network.ApiStatus
import org.d3if0103.assessment.network.ConverterApi
import retrofit2.Converter

class TentangViewModel: ViewModel() {
    private val data = MutableLiveData<List<TentangConverter>>()
    private val status = MutableLiveData<ApiStatus>()

    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(ConverterApi.service.getConverter())
                status.postValue(ApiStatus.SUCCESS)
            }

            catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<List<TentangConverter>> = data

    fun getStatus(): LiveData<ApiStatus> = status
}