package dk.shape.forecast.api.mapping

import com.google.gson.annotations.SerializedName

data class QueryResult<T>(@SerializedName("query") val query: Query<T>?)