package com.applecompose.resturantsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.applecompose.resturantsapp.presentation.ui.theme.ResturantsAppTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ResturantsAppTheme {
				RestaurantApp()

			}
		}
	}
}

@Composable
private fun RestaurantApp() {
	val navController = rememberNavController()
	NavHost(
		navController,
		startDestination = "restaurants") {

		composable(route = "restaurants") {
			RestaurantsScreen { id ->
				navController.navigate("restaurants/$id")

			}
		}
		composable(route = "restaurants/{restaurant_id}",
			arguments =
				listOf(navArgument("restaurant_id"){
					type = NavType.IntType
				})
			) { navStackEntry ->
				navStackEntry.arguments?.getInt("restaurant_id")
			RestaurantDetailScreen()
		}

	}

}



