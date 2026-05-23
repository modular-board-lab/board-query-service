package com.dbwp031.boardqueryservice

import com.dbwp031.boardqueryservice.client.DownstreamServiceProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(DownstreamServiceProperties::class)
class BoardQueryServiceApplication

fun main(args: Array<String>) {
    runApplication<BoardQueryServiceApplication>(*args)
}
