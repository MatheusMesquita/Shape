package dk.shape.forecast.usecases.places

class PlaceUIConfig(val city: String,
                    val country: String,
                    val temperature: String,
                    val temperatureColorResource: Int,
                    val onClick: () -> Unit)