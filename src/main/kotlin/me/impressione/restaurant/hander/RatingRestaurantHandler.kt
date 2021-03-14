package me.impressione.restaurant.hander

import me.impressione.restaurant.domain.Restaurant
import me.impressione.restaurant.dto.RestaurantCriteriaRequest
import org.springframework.stereotype.Component

@Component
class RatingRestaurantHandler : RestaurantCriteriaHandler {
    override fun testRestaurantMatchCriteria(
        restaurant: Restaurant,
        restaurantCriteriaRequest: RestaurantCriteriaRequest
    ) = restaurantCriteriaRequest.minCustomerRating?.let { it <= restaurant.customerRating } ?: true
}