package me.impressione.restaurant.dto

data class RestaurantCriteriaRequest(
    val name: String? = null,
    val minCustomerRating: Int? = null,
    val maxDistance: Int? = null,
    val maxPrice: Int? = null,
    val cuisine: String? = null,
)