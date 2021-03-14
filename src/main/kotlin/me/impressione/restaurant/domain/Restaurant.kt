package me.impressione.restaurant.domain

data class Restaurant(
    val name: String,
    val customerRating: Int,
    val distance: Int,
    val price: Int,
    val cuisine: Cuisine
)