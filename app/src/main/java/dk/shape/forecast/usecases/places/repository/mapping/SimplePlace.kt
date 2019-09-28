package dk.shape.forecast.usecases.places.repository.mapping

import com.google.gson.annotations.SerializedName

data class SimplePlace(
        @SerializedName("coord") val location: Location?,
        @SerializedName("sys") val details: SimplePlaceDetails?,
        @SerializedName("main") val parameters: SimplePlaceParameters?,
        @SerializedName("weather") val weathers: List<SimplePlaceWeather>?,
        @SerializedName("id") val id: Int?,
        @SerializedName("name") val name: String?
)