package me.impressione.restaurant.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.*

data class RestaurantCriteriaRequest(
    @Schema(defaultValue = "a")
    val name: String? = null,

    @field:Min(message = "Min Customer Rating is 1", value = 1)
    @field:Max(message = "Max Customer Rating is 5", value = 5)
    @JsonProperty("customerRating")
    val minCustomerRating: Int? = null,


    @field:Min(message = "Min Distance is 1", value = 1)
    @field:Max(message = "Max Distance is 10", value = 10)
    @JsonProperty("distance")
    val maxDistance: Int? = null,


    @field:Min(message = "Min Price is 10", value = 10)
    @field:Max(message = "Max Price is 50", value = 50)
    @JsonProperty("price")
    val maxPrice: Int? = null,

    @Schema(defaultValue = "Korean")
    val cuisine: String? = null,
)