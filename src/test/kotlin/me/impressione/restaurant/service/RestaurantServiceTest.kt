package me.impressione.restaurant.service

import io.mockk.every
import io.mockk.mockk
import me.impressione.restaurant.domain.Cuisine
import me.impressione.restaurant.domain.Restaurant
import me.impressione.restaurant.dto.RestaurantCriteriaRequest
import me.impressione.restaurant.hander.NameRestaurantHandler
import me.impressione.restaurant.hander.RatingRestaurantHandler
import me.impressione.restaurant.hander.RestaurantCriteriaHandler
import me.impressione.restaurant.loader.RestaurantLoader
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RestaurantServiceTest {

    private val restaurantLoader: RestaurantLoader = mockk()
    private val handlers = listOf(RatingRestaurantHandler(), NameRestaurantHandler())

    private val restaurantService = RestaurantService(restaurantLoader, handlers)

    @Test
    fun `test look for 4 start restaurants`() {

        every { restaurantLoader.restaurants } returns setOf(
            Restaurant("r1", 3, 1, 3, Cuisine(1, "brazilian")),
            Restaurant("r2", 5, 1, 3, Cuisine(1, "brazilian"))
        )

        val restaurantCriteriaRequest = RestaurantCriteriaRequest(minCustomerRating = 4)
        val findRestaurant = restaurantService.findRestaurant(restaurantCriteriaRequest)

        Assertions.assertThat(findRestaurant.size).isEqualTo(1)
        Assertions.assertThat(findRestaurant[0].name).isEqualTo("r2")
    }
}