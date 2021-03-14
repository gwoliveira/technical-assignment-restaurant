package me.impressione.restaurant.loader

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import me.impressione.restaurant.domain.Cuisine
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Component

@Component
class CuisineLoader (private val resourceLoader: ResourceLoader) {
    private val cuisines: Map<Int, Cuisine> = loadCuisines()

    private fun loadCuisines() = csvReader().open(resourceLoader.getResource("classpath:cuisines.csv").inputStream) {
        readAllWithHeaderAsSequence()
            .map { Cuisine(it["id"]?.toInt()!!, it["name"]!!) }
            .map { it.id to it }
            .toMap()
    }

    fun findCuisineById(id: Int) = cuisines[id]
}