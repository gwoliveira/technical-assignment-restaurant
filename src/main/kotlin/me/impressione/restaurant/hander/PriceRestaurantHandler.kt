package me.impressione.restaurant.hander

import me.impressione.restaurant.domain.Restaurant
import me.impressione.restaurant.dto.RestaurantCriteriaRequest
import org.springframework.stereotype.Component

@Component
class PriceRestaurantHandler : RestaurantCriteriaHandler {
    override fun testRestaurantMatchCriteria(
        restaurant: Restaurant,
        restaurantCriteriaRequest: RestaurantCriteriaRequest
    ) = restaurantCriteriaRequest.maxPrice?.let { it >= restaurant.price } ?: true
}