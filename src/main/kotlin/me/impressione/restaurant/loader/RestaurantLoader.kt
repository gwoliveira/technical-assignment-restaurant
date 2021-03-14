package me.impressione.restaurant.loader

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import me.impressione.restaurant.domain.Cuisine
import me.impressione.restaurant.domain.Restaurant
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Component

@Component
class RestaurantLoader(
    private val resourceLoader: ResourceLoader,
    private val cuisineLoader: CuisineLoader
) {
    val restaurants: Set<Restaurant> = loadRestaurants()

    private fun loadRestaurants() =
        csvReader().open(resourceLoader.getResource("classpath:restaurants.csv").inputStream) {
            readAllWithHeaderAsSequence()
                .map {
                    Restaurant(
                        it["name"]!!,
                        it["customer_rating"]!!.toInt(),
                        it["distance"]!!.toInt(),
                        it["price"]!!.toInt(),
                        cuisineLoader.findCuisineById(it["cuisine_id"]!!.toInt())!!
                    )
                }
                .toSortedSet(
                    compareBy<Restaurant> { it.distance }
                        .thenByDescending { it.customerRating }
                        .thenBy { it.price }
                )
        }

}