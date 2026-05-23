package com.dbwp031.boardqueryservice.post.dto

data class FileMetadataResponse(
    val fileId: Long,
    val originalName: String,
    val contentType: String,
    val size: Long,
    val status: String,
    val uploaderId: Long,
    val downloadUrl: String,
)
