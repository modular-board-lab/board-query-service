package com.dbwp031.boardqueryservice.post.controller

import com.dbwp031.boardqueryservice.post.dto.PostDetailViewResponse
import com.dbwp031.boardqueryservice.post.service.PostViewService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Post Views", description = "게시글 조회 조합 API")
@RestController
@RequestMapping("/bff/posts")
class PostViewController(
    private val postViewService: PostViewService,
) {
    @Operation(summary = "첨부파일 메타데이터가 포함된 게시글 상세 조회")
    @GetMapping("/{postId}")
    fun getPostView(@PathVariable postId: Long): PostDetailViewResponse =
        postViewService.getPostView(postId)
}
