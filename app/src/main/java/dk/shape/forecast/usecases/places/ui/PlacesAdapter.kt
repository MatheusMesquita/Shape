package dk.shape.forecast.usecases.places.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dk.shape.forecast.R
import dk.shape.forecast.usecases.places.PlaceUIConfig
import dk.shape.forecast.utils.ui.colorResourceToStateList
import kotlinx.android.synthetic.main.place_item.view.*

class PlacesAdapter(private val configs: List<PlaceUIConfig>) : RecyclerView.Adapter<PlacesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.place_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val config = configs[position]

        holder.view.backgroundTemperature.imageTintList = config.temperatureColorResource.colorResourceToStateList(context = holder.view.context)
        holder.view.textTemperature.text = config.temperature
        holder.view.textCity.text = config.city
        holder.view.textCountry.text = config.country
        holder.view.setOnClickListener {
            config.onClick()
        }
    }

    override fun getItemCount(): Int {
        return configs.size
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}
