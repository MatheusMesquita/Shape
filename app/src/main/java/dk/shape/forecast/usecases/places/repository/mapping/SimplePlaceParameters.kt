package dk.shape.forecast.usecases.places.repository.mapping

import com.google.gson.annotations.SerializedName

data class SimplePlaceParameters(
        @SerializedName("temp") val temperature: Float?,
        @SerializedName("pressure") val pressure: Int?,
        @SerializedName("humidity") val humidity: Int?,
        @SerializedName("temp_min") val minTemperature: Float?,
        @SerializedName("temp_max") val maxTemperature: Float?
)