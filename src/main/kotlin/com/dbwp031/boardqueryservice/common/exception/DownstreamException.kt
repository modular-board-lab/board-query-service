package com.dbwp031.boardqueryservice.common.exception

import org.springframework.http.HttpStatusCode

class DownstreamException(
    val statusCode: HttpStatusCode,
    override val message: String,
) : RuntimeException(message)
