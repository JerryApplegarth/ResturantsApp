package com.applecompose.resturantsapp.restaurants.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.applecompose.resturantsapp.restaurants.presentation.details.RestaurantDetailsScreen
import com.applecompose.resturantsapp.restaurants.presentation.list.RestaurantsScreen
import com.applecompose.resturantsapp.restaurants.presentation.list.RestaurantsViewModel
import com.applecompose.resturantsapp.restaurants.presentation.ui.theme.ResturantsAppTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ResturantsAppTheme {
				RestaurantsApp()

			}
		}
	}
}

@Composable
private fun RestaurantsApp() {
	val navController = rememberNavController()
	NavHost(navController, startDestination = "restaurants") {
		composable(route = "restaurants") {
			val viewModel: RestaurantsViewModel = viewModel()
			RestaurantsScreen(
				state = viewModel.state.value,
				onItemClick = { id ->
					navController.navigate("restaurants/$id")
				},
				onFavoriteClick = { id, oldValue ->
					viewModel.toggleFavorite(id, oldValue)
				})
		}
		composable(
			route = "restaurants/{restaurant_id}",
			arguments = listOf(navArgument("restaurant_id") {
				type = NavType.IntType
			}),
			deepLinks = listOf(navDeepLink { uriPattern =
				"www.restaurantsapp.details.com/{restaurant_id}" }),
		) { RestaurantDetailsScreen() }
	}
}
