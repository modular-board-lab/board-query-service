package com.dbwp031.boardqueryservice.common.exception

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(DownstreamException::class)
    fun handleDownstreamException(
        exception: DownstreamException,
        request: HttpServletRequest,
    ): ResponseEntity<ErrorResponse> {
        val status = if (exception.statusCode.value() == 404) {
            HttpStatus.NOT_FOUND
        } else {
            HttpStatus.BAD_GATEWAY
        }
        return buildResponse(status, "DOWNSTREAM_ERROR", exception.message, request)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(
        exception: Exception,
        request: HttpServletRequest,
    ): ResponseEntity<ErrorResponse> =
        buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR", "Internal server error", request)

    private fun buildResponse(
        status: HttpStatus,
        code: String,
        message: String,
        request: HttpServletRequest,
    ): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(status).body(
            ErrorResponse(
                timestamp = LocalDateTime.now(),
                status = status.value(),
                error = status.reasonPhrase,
                code = code,
                message = message,
                path = request.requestURI,
            ),
        )
}

data class ErrorResponse(
    val timestamp: LocalDateTime,
    val status: Int,
    val error: String,
    val code: String,
    val message: String,
    val path: String,
)
