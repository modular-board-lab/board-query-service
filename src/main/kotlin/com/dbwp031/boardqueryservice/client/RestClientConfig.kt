package com.dbwp031.boardqueryservice.client

import org.springframework.boot.web.client.RestClientCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient

@Configuration
class RestClientConfig {
    @Bean
    fun restClientBuilder(customizers: List<RestClientCustomizer>): RestClient.Builder {
        val builder = RestClient.builder()
        customizers.forEach { it.customize(builder) }
        return builder
    }
}
