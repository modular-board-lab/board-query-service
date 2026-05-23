package com.dbwp031.boardqueryservice.post.dto

import java.time.LocalDateTime

data class PostDetailViewResponse(
    val id: Long,
    val boardId: Long,
    val title: String,
    val content: String,
    val writerName: String,
    val attachments: List<PostAttachmentResponse>,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {
    companion object {
        fun of(post: BoardPostResponse, attachments: List<FileMetadataResponse>): PostDetailViewResponse =
            PostDetailViewResponse(
                id = post.id,
                boardId = post.boardId,
                title = post.title,
                content = post.content,
                writerName = post.writerName,
                attachments = attachments.map(PostAttachmentResponse::from),
                createdAt = post.createdAt,
                updatedAt = post.updatedAt,
            )
    }
}

data class PostAttachmentResponse(
    val fileId: Long,
    val originalName: String,
    val contentType: String,
    val size: Long,
    val downloadUrl: String,
) {
    companion object {
        fun from(file: FileMetadataResponse): PostAttachmentResponse =
            PostAttachmentResponse(
                fileId = file.fileId,
                originalName = file.originalName,
                contentType = file.contentType,
                size = file.size,
                downloadUrl = file.downloadUrl,
            )
    }
}
