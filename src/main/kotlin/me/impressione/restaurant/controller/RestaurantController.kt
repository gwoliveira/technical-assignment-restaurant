package me.impressione.restaurant.controller

import io.micrometer.core.annotation.Timed
import me.impressione.restaurant.dto.RestaurantCriteriaRequest
import me.impressione.restaurant.service.RestaurantService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RestaurantController(private val restaurantService: RestaurantService) {

    @Timed
    @GetMapping("/restaurants")
    fun findRestaurant(@RequestBody @Validated restaurantCriteriaRequest: RestaurantCriteriaRequest) = restaurantService.findRestaurant(restaurantCriteriaRequest);
}