# board-query-service

게시글 상세 조회 화면을 위한 BFF/aggregation 서비스입니다. `board-service`에서 게시글 본문과 첨부 `fileId` 목록을 조회하고, `file-service`에서 첨부파일 메타데이터를 조회해 하나의 응답으로 조합합니다.

## 실행

```bash
./gradlew bootRun
```

기본 포트는 `8084`입니다.

```bash
curl http://localhost:8084/bff/posts/1
```

## Downstream 설정

```yaml
services:
  board-service:
    url: http://localhost:8081
  file-service:
    url: http://localhost:8083
```

환경 변수 `BOARD_SERVICE_URL`, `FILE_SERVICE_URL`로 조정할 수 있습니다.

## Gateway 연결

api-gateway는 `/bff/posts/**`를 이 서비스로 라우팅합니다. 클라이언트는 게시글과 첨부파일 정보를 한 번에 조회할 때 gateway의 `/bff/posts/{postId}`를 호출하면 됩니다.
