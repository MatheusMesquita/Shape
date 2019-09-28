# Forecast

The Forecast app is a simple weather app that shows the weather forecast for different places
in the world. The app will show a list of location and the user can click on one of the locations
to get detailed information about the weather forecast for the given location.

Forecast uses OpenWeatherMap’s weather service as its data provider (https://openweathermap.org/current). The Overview screens shows a list of locations in the world. Every location is
identified based on a "city id". The details screen uses the “city id” to load the forecast for the
given location.

## Your task

Currently the app only contains the Overview screen. Your task is to add the Details screen,
that is shown when the user taps on one of the locations from the Overview screen.
Setup the Details screen, so it shows a spinner while the data is being loaded. Additionally
you could add error handling, in case loading the data fails.

You are allowed to make changes to any parts of the code, that are already there. However,
we do hope, you will strive to follow the architectural patterns applied in the current code

## Resources

If you are not familiar with Clean Architecture, there are a lot of resources around to check
out. You can start with a general overview here:
https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html

To keep the project simple, we have kept the use of third party libraries to a minimum.
However, we do use a Retrofit for http requests coupled with GSON for json parsing. You can
read more about how it works here:
http://square.github.io/retrofit/

## Weather details data

The endpoint to get weather details based on a city id:

`https://api.openweathermap.org/data/2.5/weather?id={cityId}&units={unitName}`

Example using Barcelona's city ID and `metric` units:

`https://api.openweathermap.org/data/2.5/weather?id=3128760&units=metric`

All details are documented in https://openweathermap.org/current#by_city_id



