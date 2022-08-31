package com.applecompose.resturantsapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RestaurantsViewModel(): ViewModel() {
	val state = mutableStateOf(dummyRestaurants)

	fun toggleFavorite(id: Int) {
		val restaurants = state.value.toMutableList()
		val itemIndex =
			restaurants.indexOfFirst { it.id == id }
		val item = restaurants[itemIndex]
		restaurants[itemIndex] =
			item.copy(isFavorite = !item.isFavorite)
		state.value = restaurants
	}



}