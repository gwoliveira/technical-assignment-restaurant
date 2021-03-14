package me.impressione.restaurant.hander

import me.impressione.restaurant.domain.Restaurant
import me.impressione.restaurant.dto.RestaurantCriteriaRequest

interface RestaurantCriteriaHandler {

    fun testRestaurantMatchCriteria(restaurant: Restaurant, restaurantCriteriaRequest: RestaurantCriteriaRequest): Boolean

}