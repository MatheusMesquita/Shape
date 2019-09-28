package dk.shape.forecast

import androidx.appcompat.app.AppCompatActivity
import dk.shape.forecast.api.initHttpClient
import dk.shape.forecast.api.initWeatherAPI
import dk.shape.forecast.usecases.places.PlacesConfig
import dk.shape.forecast.usecases.places.repository.PlacesRepository

object AppConfig {
    private val woeIds = listOf(
            "2643743",
            "2950159",
            "3128760",
            "2267057",
            "2964574",
            "2618425",
            "524901",
            "5128581",
            "5375480",
            "2147714",
            "292223",
            "2988507")

    private val apiKey = "637317c95527d7842a78fdb241e1dda8"

    private val httpClient by lazy { initHttpClient(apiKey) }
    private val weatherAPI by lazy { initWeatherAPI(httpClient) }

    /**
     * Initializes the Places use case configuration.
     *
     * @param The parent activity used to launch new activities and manage lifecycle events.
     */
    fun initPlacesConfig(activity: AppCompatActivity) =
            PlacesConfig(
                    activity = activity,
                    placesRepository = PlacesRepository(
                            weatherAPI = weatherAPI,
                            woeIds = woeIds))
}