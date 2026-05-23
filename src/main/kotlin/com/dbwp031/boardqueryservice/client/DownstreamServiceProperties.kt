package com.dbwp031.boardqueryservice.client

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "services")
data class DownstreamServiceProperties(
    val boardService: ServiceEndpoint = ServiceEndpoint("http://localhost:8081"),
    val fileService: ServiceEndpoint = ServiceEndpoint("http://localhost:8083"),
)

data class ServiceEndpoint(
    val url: String,
)
