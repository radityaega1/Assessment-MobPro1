package org.d3if0103.assessment.model

import org.d3if0103.assessment.db.ConverterEntity

fun ConverterEntity.hitungConverter1(): HasilConverter {
    val panjang1 = panjang
    val hasil1 = panjang * 10
    return HasilConverter(hasil1)
}

fun ConverterEntity.hitungConverter2(): HasilConverter {
    val panjang2 = panjang
    val hasil2 = panjang * 100
    return HasilConverter(hasil2)
}

fun ConverterEntity.hitungConverter3(): HasilConverter {
    val panjang3 = panjang
    val hasil3 = panjang * 1000
    return HasilConverter(hasil3)
}

fun ConverterEntity.hitungConverter4(): HasilConverter {
    val panjang4 = panjang
    val hasil4 = panjang * 10000
    return HasilConverter(hasil4)
}

fun ConverterEntity.hitungConverter5(): HasilConverter {
    val panjang5 = panjang
    val hasil5 = panjang * 100000
    return HasilConverter(hasil5)
}

fun ConverterEntity.hitungConverter6(): HasilConverter {
    val panjang6 = panjang
    val hasil6 = panjang * 1000000
    return HasilConverter(hasil6)
}