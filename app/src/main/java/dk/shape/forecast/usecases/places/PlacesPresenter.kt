package dk.shape.forecast.usecases.places

import dk.shape.forecast.utils.ui.toColorResource

interface PlacesPresenter {
    var onStateChanged: (State) -> Unit

    sealed class State {
        class Content(val uiConfigs: List<PlaceUIConfig>) : State()
        object Loading : State()
        class Error(val onRetry: () -> Unit) : State()
    }
}

class PlacesPresenterImpl(interactor: PlacesInteractor) : PlacesPresenter {

    override var onStateChanged: (PlacesPresenter.State) -> Unit = {}
        set(value) {
            field = value
            onStateChanged(state)
        }

    private var state: PlacesPresenter.State = PlacesPresenter.State.Loading
        set(value) {
            if (field != value) {
                field = value
                onStateChanged(value)
            }
        }

    init {
        interactor.onStateChanged = { state ->
            this.state = when (state) {
                is PlacesInteractor.State.Content -> state.map()
                is PlacesInteractor.State.Loading -> PlacesPresenter.State.Loading
                is PlacesInteractor.State.Error -> PlacesPresenter.State.Error(
                        onRetry = { state.onRetry() }
                )
            }
        }
    }
}

private fun PlacesInteractor.State.Content.map(): PlacesPresenter.State.Content {
    val uiConfigs = placeHandlers.map { handler ->
        val place = handler.place

        PlaceUIConfig(
                city = place.city,
                country = place.country,
                temperature = "${place.temperature.value} ${place.temperature.unit.postFix}",
                temperatureColorResource = place.temperature.toColorResource(),
                onClick = handler.onClick)
    }
    return PlacesPresenter.State.Content(uiConfigs = uiConfigs)
}