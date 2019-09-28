package dk.shape.forecast.usecases.places.repository.mapping

import com.google.gson.annotations.SerializedName

data class SimplePlaceWeather(
        @SerializedName("id") val id: Int?,
        @SerializedName("main") val name: String?,
        @SerializedName("description") val description: String?,
        @SerializedName("icon") val icon: String?
)