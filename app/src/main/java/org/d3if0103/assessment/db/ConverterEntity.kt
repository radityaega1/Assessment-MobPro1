package org.d3if0103.assessment.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ConverterEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    val panjang: Float
)
