package dk.shape.forecast.api.mapping

import com.google.gson.annotations.SerializedName

class Query<T>(@SerializedName("count") val count: Int?,
               @SerializedName("created") val created: String?,
               @SerializedName("results") val results: T)