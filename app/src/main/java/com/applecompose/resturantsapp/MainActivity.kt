package com.applecompose.resturantsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.applecompose.resturantsapp.presentation.screens.RestaurantsScreen
import com.applecompose.resturantsapp.presentation.ui.theme.ResturantsAppTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ResturantsAppTheme {
				RestaurantsScreen()
			}
		}
	}
}



