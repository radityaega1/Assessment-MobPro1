package org.d3if0103.assessment.ui.hitung

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if0103.assessment.db.ConverterDao
import org.d3if0103.assessment.db.ConverterEntity
import org.d3if0103.assessment.model.HasilConverter
import org.d3if0103.assessment.model.*

class HitungViewModel(private val db:ConverterDao): ViewModel() {
    private val hasilConverter1 = MutableLiveData<HasilConverter?>()
    private val hasilConverter2 = MutableLiveData<HasilConverter?>()
    private val hasilConverter3 = MutableLiveData<HasilConverter?>()
    private val hasilConverter4 = MutableLiveData<HasilConverter?>()
    private val hasilConverter5 = MutableLiveData<HasilConverter?>()
    private val hasilConverter6 = MutableLiveData<HasilConverter?>()

    fun hitungConverter1(panjang: Float) {
        val dataConverter = ConverterEntity(
            panjang = panjang,
        )

        hasilConverter1.value = dataConverter.hitungConverter1()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataConverter)
            }
        }
    }

    fun hitungConverter2(panjang: Float) {
        val dataConverter = ConverterEntity(
            panjang = panjang,
        )

        hasilConverter2.value = dataConverter.hitungConverter2()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataConverter)
            }
        }
    }

    fun hitungConverter3(panjang: Float) {
        val dataConverter = ConverterEntity(
            panjang = panjang,
        )

        hasilConverter3.value = dataConverter.hitungConverter3()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataConverter)
            }
        }
    }

    fun hitungConverter4(panjang: Float) {
        val dataConverter = ConverterEntity(
            panjang = panjang,
        )

        hasilConverter4.value = dataConverter.hitungConverter4()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataConverter)
            }
        }
    }

    fun hitungConverter5(panjang: Float) {
        val dataConverter = ConverterEntity(
            panjang = panjang,
        )

        hasilConverter5.value = dataConverter.hitungConverter5()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataConverter)
            }
        }
    }

    fun hitungConverter6(panjang: Float) {
        val dataConverter = ConverterEntity(
            panjang = panjang,
        )

        hasilConverter6.value = dataConverter.hitungConverter6()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataConverter)
            }
        }
    }

    fun getHasil1(): LiveData<HasilConverter?> = hasilConverter1
    fun getHasil2(): LiveData<HasilConverter?> = hasilConverter2
    fun getHasil3(): LiveData<HasilConverter?> = hasilConverter3
    fun getHasil4(): LiveData<HasilConverter?> = hasilConverter4
    fun getHasil5(): LiveData<HasilConverter?> = hasilConverter5
    fun getHasil6(): LiveData<HasilConverter?> = hasilConverter6
}