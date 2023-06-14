package org.d3if0103.assessment.network

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import org.d3if0103.assessment.model.TentangConverter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/" +
        "radityaega1/Assessment-MobPro1/static-api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET("static-api.json")
    suspend fun getConverter(): List<TentangConverter>
}

object ConverterApi {
    val service: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    fun getConverterUrl(imageId: String): String {
        return "$BASE_URL$imageId.jpg"
    }
}

enum class ApiStatus{LOADING, SUCCESS, FAILED}