package com.dbwp031.boardqueryservice.post.dto

import java.time.LocalDateTime

data class BoardPostResponse(
    val id: Long,
    val boardId: Long,
    val title: String,
    val content: String,
    val writerName: String,
    val attachmentFileIds: List<Long> = emptyList(),
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)
