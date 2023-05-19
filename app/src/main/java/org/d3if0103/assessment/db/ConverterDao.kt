package org.d3if0103.assessment.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ConverterDao {
    @Insert
    fun insert(converter: ConverterEntity)

    @Query("SELECT * FROM converterpanjang")
    fun getLastConverter(): LiveData<List<ConverterEntity>>

    @Query("DELETE FROM converterpanjang")
    fun clearData()
}