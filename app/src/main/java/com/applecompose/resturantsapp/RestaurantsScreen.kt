package com.applecompose.resturantsapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.applecompose.resturantsapp.Restaurant
import com.applecompose.resturantsapp.RestaurantsViewModel

@Composable
fun RestaurantsScreen() {
	val viewModel: RestaurantsViewModel = viewModel()
	LazyColumn(
		contentPadding = PaddingValues(
			vertical = 8.dp,
			horizontal = 8.dp
		)
	) {

		items(viewModel.getRestaurants()) { restaurant ->
			RestaurantItem(restaurant)
		}
	}
}

@Composable
fun RestaurantItem(item: Restaurant) {
	var favoriteState = remember { mutableStateOf(false) }
	val icon = if (favoriteState.value) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder
	Card(
		elevation = 4.dp,
		modifier = Modifier.padding(8.dp)
	) {
		Row(
			verticalAlignment = Alignment.CenterVertically,
			modifier = Modifier.padding(8.dp)
		) {
			RestaurantIcon(
				Icons.Filled.Place,
				Modifier.weight(0.15f)
			)
			RestaurantDetails(
				item.title,
				item.description,
				Modifier.weight(0.7f)
			)
			FavoriteIcon(
				icon,
				Modifier.weight(0.15f)
			) {
				favoriteState.value =
					!favoriteState.value
			}

		}
	}
}

@Composable
fun FavoriteIcon(
	icon: ImageVector,
	modifier: Modifier,
	onClick: () -> Unit
) {

	Image(
		imageVector = icon,
		contentDescription = "Favorite restaurant icon",
		modifier = Modifier
			.padding(8.dp)
			.clickable { onClick() }
	)

}

@Composable
private fun RestaurantIcon(icon: ImageVector, modifier: Modifier) {
	Image(
		imageVector = icon,
		contentDescription = "Restaurant icon",
		modifier = modifier.padding(8.dp)
	)
}

@Composable
private fun RestaurantDetails(title: String, description: String, modifier: Modifier) {
	Column(modifier = modifier) {
		Text(
			text = title,
			style = MaterialTheme.typography.h6
		)
		CompositionLocalProvider(
			LocalContentAlpha provides ContentAlpha.medium
		) {
			Text(
				text = description,
				style = MaterialTheme.typography.body2
			)
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





