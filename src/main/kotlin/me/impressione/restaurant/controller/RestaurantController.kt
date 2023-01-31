package me.impressione.restaurant.controller

import io.micrometer.core.annotation.Timed
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import me.impressione.restaurant.dto.RestaurantCriteriaRequest
import me.impressione.restaurant.service.RestaurantService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Validated
@RestController
class RestaurantController(private val restaurantService: RestaurantService) {

    @Timed
    @GetMapping("/restaurants")
    fun findRestaurant(
        @RequestParam name: String?,
        @Min(message = "Min Customer Rating is 1", value = 1)
        @Max(message = "Max Customer Rating is 5", value = 5)
        @RequestParam("customer-rating") minCustomerRating: Int?,
        @Min(message = "Min Distance is 1", value = 1)
        @Max(message = "Max Distance is 10", value = 10)
        @RequestParam("distance") maxDistance: Int?,
        @Min(message = "Min Price is 10", value = 10)
        @Max(message = "Max Price is 50", value = 50)
        @RequestParam("price") maxPrice: Int?,
        @RequestParam cuisine: String?
    ) = restaurantService.findRestaurant(
        RestaurantCriteriaRequest(
            name,
            minCustomerRating,
            maxDistance,
            maxPrice,
            cuisine
        )
    )
}