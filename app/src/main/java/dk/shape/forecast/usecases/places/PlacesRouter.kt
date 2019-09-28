package dk.shape.forecast.usecases.places

import android.app.Activity
import android.util.Log
import java.lang.ref.WeakReference

interface PlacesRouter {
    fun onPlaceSelected(woeid: String)
}

class PlacesRouterImpl(activity: Activity): PlacesRouter {
    override fun onPlaceSelected(woeid: String) {
        Log.d("PlacesRouter", "No forecast to show for WOEID $woeid, please implement this")
        // TODO: Show the forecast for the location identified by the supplied WOEID
    }

    val activityRef = WeakReference<Activity>(activity)
}