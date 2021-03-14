package me.impressione.restaurant.hander

import me.impressione.restaurant.domain.Restaurant
import me.impressione.restaurant.dto.RestaurantCriteriaRequest
import org.springframework.stereotype.Component

@Component
class NameRestaurantHandler : RestaurantCriteriaHandler {
    override fun testRestaurantMatchCriteria(
        restaurant: Restaurant,
        restaurantCriteriaRequest: RestaurantCriteriaRequest
    ) = restaurant.name.contains(restaurantCriteriaRequest.name ?: "");
}