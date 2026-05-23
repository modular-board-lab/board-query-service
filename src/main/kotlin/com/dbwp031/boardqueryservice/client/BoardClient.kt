package com.dbwp031.boardqueryservice.client

import com.dbwp031.boardqueryservice.common.exception.DownstreamException
import com.dbwp031.boardqueryservice.post.dto.BoardPostResponse
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import org.springframework.web.client.RestClientResponseException

@Component
class BoardClient(
    restClientBuilder: RestClient.Builder,
    properties: DownstreamServiceProperties,
) {
    private val restClient = restClientBuilder
        .baseUrl(properties.boardService.url)
        .build()

    fun getPost(postId: Long): BoardPostResponse =
        try {
            restClient.get()
                .uri("/posts/{postId}", postId)
                .retrieve()
                .body(BoardPostResponse::class.java)
                ?: throw DownstreamException(HttpStatus.BAD_GATEWAY, "Empty response from board-service")
        } catch (exception: RestClientResponseException) {
            throw DownstreamException(exception.statusCode, "board-service request failed")
        }
}
