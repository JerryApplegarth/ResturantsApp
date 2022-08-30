package com.applecompose.resturantsapp.presentation.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.applecompose.resturantsapp.data.dummyRestaurants
import com.applecompose.resturantsapp.presentation.components.RestaurantItem

@Composable
fun RestaurantsScreen() {
	LazyColumn(
		contentPadding = PaddingValues(
			vertical = 8.dp,
			horizontal = 8.dp
		)
	) {
		items(dummyRestaurants) { restaurant ->
			RestaurantItem(restaurant)
		}
	}
}

@Preview(
	showSystemUi = true,
	showBackground = true,
	name = "Restaurant Screen"
)
@Composable
fun RestaurantScreenPreview() {
	RestaurantsScreen()
}






