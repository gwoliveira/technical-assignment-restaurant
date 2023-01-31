package me.impressione.restaurant.controller

import me.impressione.restaurant.domain.Cuisine
import me.impressione.restaurant.domain.Restaurant
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.RequestEntity


@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class RestaurantControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `test request with wrong distance parameter`() {
        val request = RequestEntity.get("/restaurants?customer-rating=5&cuisine=Chinese&distance=-10")
            .build()

        val response = restTemplate.exchange(request, object : ParameterizedTypeReference<String>() {})

        Assertions.assertThat(response.statusCode.is4xxClientError).isTrue
        Assertions.assertThat(response.body).isEqualTo("findRestaurant.maxDistance: Min Distance is 1")
    }

    @Test
    fun `test request give first 5 stars with Chinese cuisine`() {
        val request = RequestEntity.get("/restaurants?customer-rating=5&cuisine=Chinese")
            .build()
        val response = restTemplate.exchange(request, object : ParameterizedTypeReference<Set<Restaurant>>() {})

        Assertions.assertThat(response.statusCode.is2xxSuccessful).isTrue
        Assertions.assertThat(response.body).hasSize(3)
        Assertions.assertThat(response.body).first()
            .isEqualTo(Restaurant("Gusto Delicious", 5, 3, 50, Cuisine(2, "Chinese")))
    }
}