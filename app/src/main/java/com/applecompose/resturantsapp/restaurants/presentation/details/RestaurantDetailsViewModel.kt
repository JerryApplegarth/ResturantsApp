package com.applecompose.resturantsapp.restaurants.presentation.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applecompose.resturantsapp.restaurants.data.remote.RestaurantsApiService
import com.applecompose.resturantsapp.restaurants.domain.Restaurant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RestaurantDetailsViewModel(private val stateHandle: SavedStateHandle): ViewModel() {
	private var restInterface: RestaurantsApiService
	val state = mutableStateOf<Restaurant?>(null)

	init {
		val retrofit: Retrofit = Retrofit.Builder()
			.addConverterFactory(GsonConverterFactory.create())
			.baseUrl("https://my-api-60a0d-default-rtdb.firebaseio.com/")
			.build()
		restInterface = retrofit.create(RestaurantsApiService::class.java)

		val id = stateHandle.get<Int>("restaurant_id") ?: 0
		viewModelScope.launch {
			val restaurant = getRemoteRestaurant(id)
			state.value = restaurant
		}
	}

	private suspend fun getRemoteRestaurant(id: Int): Restaurant {
		return withContext(Dispatchers.IO) {
			val response =  restInterface.getRestaurant(id)
			return@withContext response.values.first().let {
				Restaurant(id = it.id, title = it.title, description = it.description)
			}
		}
	}
}

//   https://my-api-60a0d-default-rtdb.firebaseio.com/
