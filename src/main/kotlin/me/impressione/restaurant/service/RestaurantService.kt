package me.impressione.restaurant.service

import me.impressione.restaurant.dto.RestaurantCriteriaRequest
import me.impressione.restaurant.hander.RestaurantCriteriaHandler
import me.impressione.restaurant.loader.RestaurantLoader
import org.springframework.stereotype.Service

@Service
class RestaurantService (
    private val restaurantLoader: RestaurantLoader,
    private val handlers: List<RestaurantCriteriaHandler>
    ){

    fun findRestaurant(restaurantCriteriaRequest: RestaurantCriteriaRequest) =
        restaurantLoader.restaurants
            .filter {restaurant ->
                handlers.all { it.testRestaurantMatchCriteria(restaurant, restaurantCriteriaRequest)}
            }
        .take(5);

}