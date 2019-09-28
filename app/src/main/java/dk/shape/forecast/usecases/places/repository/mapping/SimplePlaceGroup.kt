package dk.shape.forecast.usecases.places.repository.mapping

import com.google.gson.annotations.SerializedName

data class SimplePlaceGroup(
        @SerializedName("cnt") val count: Int?,
        @SerializedName("list") val places: List<SimplePlace>?
)