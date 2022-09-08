package com.applecompose.resturantsapp.restaurants.presentation.list

import com.applecompose.resturantsapp.restaurants.domain.Restaurant

data class RestaurantsScreenState(
	val restaurants: List<Restaurant>,
	val isLoading: Boolean,
	val error: String? = null
)