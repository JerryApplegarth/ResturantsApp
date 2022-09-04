package com.applecompose.resturantsapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RestaurantsDetailsViewModel(): ViewModel() {
	private var restInference: RestaurantsApiService
	val state = mutableStateOf<Restaurant?>(null)
	init {
		val retrofit: Retrofit = Retrofit.Builder()
			.addConverterFactory(GsonConverterFactory.create())
			.baseUrl("https://my-api-60a0d-default-rtdb.firebaseio.com/")
			.build()
		restInference = retrofit.create(RestaurantsApiService::class.java)
		viewModelScope.launch {
			val restaurant = getRemoteRestaurant(2)
			state.value = restaurant
		}

	}
	private suspend fun getRemoteRestaurant(id: Int):
			Restaurant {
		return withContext(Dispatchers.IO) {
			val resposeMap = restInference
				.getRestaurant(id)
			return@withContext resposeMap.values.first()
		}
	}
}