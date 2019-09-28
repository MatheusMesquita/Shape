package dk.shape.forecast.usecases.places.repository

import dk.shape.forecast.api.WeatherAPI
import dk.shape.forecast.entities.Place
import dk.shape.forecast.framework.Promise
import dk.shape.forecast.entities.Temperature
import dk.shape.forecast.entities.TemperatureUnit
import dk.shape.forecast.usecases.places.repository.mapping.SimplePlace
import dk.shape.forecast.usecases.places.repository.mapping.SimplePlaceGroup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.util.*

class PlacesRepository(
        private val weatherAPI: WeatherAPI,
        woeIds: List<String>
) {

    private val ids = woeIds.joinToString(separator = ",")

    /**
     * Returns a Promise that will at some point return the List of Places.
     */
    val places: Promise<List<Place>>
        get() {
            val promise = Promise<List<Place>>()

            weatherAPI.placesQuery(ids = ids)
                    .enqueue(object : Callback<SimplePlaceGroup> {
                        override fun onResponse(call: Call<SimplePlaceGroup>, response: Response<SimplePlaceGroup>) {
                            if (!response.isSuccessful) {
                                promise.error(IOException("Response was unsuccessful: ${response.code()}"))
                                return
                            }

                            val result = response.body()
                            if (result == null) {
                                promise.error(IOException("Response has no body"))
                                return
                            }

                            result.let { placeGroup ->
                                promise.success(placeGroup.asPlaces())
                            }
                        }

                        override fun onFailure(call: Call<SimplePlaceGroup>, t: Throwable) {
                            promise.error(t)
                        }
                    })

            return promise
        }
}

private fun SimplePlaceGroup.asPlaces(): List<Place> {
    return places.orEmpty().mapNotNull { it.asPlace() }
}

private fun SimplePlace.asPlace(): Place? {
    val woeId = id?.toString() ?: return null
    val weatherCode = weathers?.firstOrNull()?.id ?: return null
    val city = name ?: return null
    val country = getCountryNameFromCountryCode(details?.countryCode) ?: return null
    val temperature = parameters?.temperature?.toInt() ?: return null

    return Place(
            woeId = woeId,
            city = city,
            country = country,
            temperature = Temperature(
                    value = temperature,
                    unit = TemperatureUnit.Celsius),
            weatherCode = weatherCode)
}

private fun getCountryNameFromCountryCode(countryCode: String?): String? {
    val code = countryCode ?: return null
    return Locale("", code).displayCountry
}