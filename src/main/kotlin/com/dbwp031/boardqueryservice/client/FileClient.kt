package com.dbwp031.boardqueryservice.client

import com.dbwp031.boardqueryservice.common.exception.DownstreamException
import com.dbwp031.boardqueryservice.post.dto.FileMetadataResponse
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import org.springframework.web.client.RestClientResponseException

@Component
class FileClient(
    restClientBuilder: RestClient.Builder,
    properties: DownstreamServiceProperties,
) {
    private val restClient = restClientBuilder
        .baseUrl(properties.fileService.url)
        .build()

    fun getFileOrNull(fileId: Long): FileMetadataResponse? =
        try {
            restClient.get()
                .uri("/files/{fileId}", fileId)
                .retrieve()
                .body(FileMetadataResponse::class.java)
                ?: throw DownstreamException(HttpStatus.BAD_GATEWAY, "Empty response from file-service")
        } catch (exception: RestClientResponseException) {
            if (exception.statusCode.value() == 404) {
                null
            } else {
                throw DownstreamException(exception.statusCode, "file-service request failed")
            }
        }
}
