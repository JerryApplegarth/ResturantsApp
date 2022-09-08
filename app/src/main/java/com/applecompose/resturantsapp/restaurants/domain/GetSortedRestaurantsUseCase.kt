package com.applecompose.resturantsapp.restaurants.domain

import com.applecompose.resturantsapp.restaurants.data.RestaurantsRepository

class GetSortedRestaurantsUseCase {
	private val repository: RestaurantsRepository =
		RestaurantsRepository()
	suspend operator fun invoke(): List<Restaurant> {
		return repository.getRestaurants()
			.sortedBy { it.title }
	}
}