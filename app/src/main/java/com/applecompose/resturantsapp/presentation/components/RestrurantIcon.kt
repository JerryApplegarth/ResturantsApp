package com.applecompose.resturantsapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun RestaurantIcon(icon: ImageVector, modifier: Modifier) {
	Image(
		imageVector = icon,
		contentDescription = "Restaurant icon",
		modifier = modifier.padding(8.dp)
	)
}