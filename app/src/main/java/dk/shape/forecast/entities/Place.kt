package dk.shape.forecast.entities

data class Place(val woeId: String,
                 val city: String,
                 val country: String,
                 val temperature: Temperature,
                 val weatherCode: Int)