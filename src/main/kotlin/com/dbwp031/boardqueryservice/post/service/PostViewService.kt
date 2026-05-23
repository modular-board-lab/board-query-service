package com.dbwp031.boardqueryservice.post.service

import com.dbwp031.boardqueryservice.client.BoardClient
import com.dbwp031.boardqueryservice.client.FileClient
import com.dbwp031.boardqueryservice.post.dto.PostDetailViewResponse
import org.springframework.stereotype.Service

@Service
class PostViewService(
    private val boardClient: BoardClient,
    private val fileClient: FileClient,
) {
    fun getPostView(postId: Long): PostDetailViewResponse {
        val post = boardClient.getPost(postId)
        val attachments = post.attachmentFileIds.mapNotNull(fileClient::getFileOrNull)

        return PostDetailViewResponse.of(post, attachments)
    }
}
