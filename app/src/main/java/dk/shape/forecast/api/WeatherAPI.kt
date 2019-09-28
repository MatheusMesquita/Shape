package dk.shape.forecast.api

import dk.shape.forecast.usecases.places.repository.mapping.SimplePlaceGroup
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val baseUrl = "https://api.openweathermap.org/data/2.5/"

interface WeatherAPI {
    @GET("group")
    fun placesQuery(@Query("id") ids: String,
                    @Query("units") units: String = "metric"): Call<SimplePlaceGroup>
}

fun initHttpClient(apiKey: String): OkHttpClient {
    return OkHttpClient.Builder()
            .addInterceptor { chain ->
                var request = chain.request()
                val url = request.url().newBuilder().addQueryParameter("appId", apiKey).build()
                request = request.newBuilder().url(url).build()
                chain.proceed(request)
            }.build()
}

fun initWeatherAPI(httpClient: OkHttpClient): WeatherAPI {
    val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    return retrofit.create(WeatherAPI::class.java)
}