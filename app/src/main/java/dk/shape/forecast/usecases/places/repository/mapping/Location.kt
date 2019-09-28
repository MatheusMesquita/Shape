package dk.shape.forecast.usecases.places.repository.mapping

import com.google.gson.annotations.SerializedName

data class Location(@SerializedName("lat") val latitude: Double?,
                    @SerializedName("lon") val longitude: Double?)