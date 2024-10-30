package com.ssafy.commerce.demo.handler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * GitHub 웹훅을 받아서 Mattermost로 전달하는 컨트롤러
 * REST API 엔드포인트를 제공하여 GitHub의 이벤트를 처리합니다.
 */
@RestController
public class WebhookController {

    // Mattermost 웹훅 URL (application.properties에서 설정)
    @Value("${mattermost.webhook.url}")
    private String mattermostWebhookUrl;

    // GitHub 웹훅 시크릿 키 (보안 검증용)
    @Value("${github.secret}")
    private String githubSecret;

    // Mattermost 채널명 (기본값을 다음과 같이 변경: ${WEBHOOK_CHANNEL})
    @Value("${mattermost.channel:완진이랑공유}")
    private String mattermostChannel;

    // HTTP 요청을 위한 RestTemplate 인스턴스
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * GitHub 웹훅을 처리하는 메인 엔드포인트
     * @param payload GitHub에서 전송된 JSON 페이로드
     * @param signature GitHub의 서명 (보안 검증용)
     * @param event GitHub 이벤트 타입 (push, pull_request 등)
     * @return 처리 결과 응답
     */
    @PostMapping("/webhook")
    public ResponseEntity<String> handleWebhook(
        @RequestBody String payload,
        @RequestHeader("X-Hub-Signature-256") String signature,
        @RequestHeader("X-GitHub-Event") String event) {

        // GitHub 시그니처 검증
        if (!verifySignature(payload, signature)) {
            return ResponseEntity.status(401).body("Invalid signature");
        }

        try {
            // JSON 파싱
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(payload);

            // GitHub 이벤트 메시지 포맷팅
            String message = formatGithubMessage(rootNode, event);

            // Mattermost 페이로드 구성
            MattermostPayload mattermostPayload = new MattermostPayload();
            mattermostPayload.setChannel(mattermostChannel);
            mattermostPayload.setText(message);

            // HTTP 헤더 설정
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<MattermostPayload> request =
                new HttpEntity<>(mattermostPayload, headers);

            // Mattermost로 메시지 전송
            restTemplate.postForEntity(
                mattermostWebhookUrl,
                request,
                String.class
            );

            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            return ResponseEntity.status(500)
                .body("Error processing webhook: " + e.getMessage());
        }
    }

    /**
     * GitHub 웹훅 시그니처 검증
     * HMAC-SHA256을 사용하여 페이로드의 무결성을 검증합니다.
     * @param payload 원본 페이로드
     * @param headerSignature GitHub에서 전송한 시그니처
     * @return 검증 결과
     */
    private boolean verifySignature(String payload, String headerSignature) {
        try {
            // HMAC-SHA256 인스턴스 생성
            Mac mac = Mac.getInstance("HmacSHA256");

            // 시크릿 키로 서명 생성
            SecretKeySpec secretKeySpec =
                new SecretKeySpec(githubSecret.getBytes(), "HmacSHA256");
            mac.init(secretKeySpec);

            // 페이로드 서명 및 인코딩
            String signature = "sha256=" +
                Hex.encodeHexString(mac.doFinal(payload.getBytes()));
            System.out.println("Received signature: " + headerSignature);
            System.out.println("Calculated signature: " + signature);
            // 시그니처 비교 (타이밍 어택 방지를 위해 MessageDigest.isEqual 사용)
            return MessageDigest.isEqual(
                headerSignature.getBytes(),
                signature.getBytes()
            );
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * GitHub 이벤트를 Mattermost 메시지로 포맷팅
     * @param payload GitHub 이벤트 페이로드
     * @param eventType 이벤트 타입 (push, pull_request 등)
     * @return 포맷팅된 마크다운 메시지
     */
    private String formatGithubMessage(JsonNode payload, String eventType) {
        StringBuilder message = new StringBuilder();
        System.out.println("Received payload: " + payload);
        switch (eventType) {
            case "push":
                // Push 이벤트 처리
                String repo = payload.get("repository")
                    .get("full_name").asText();
                String branch = payload.get("ref")
                    .asText().split("/")[2];
                message.append(String.format(
                    "### GitHub Push to %s:%s\n", repo, branch));

                // 커밋 정보 추가
                JsonNode commits = payload.get("commits");
                for (JsonNode commit : commits) {
                    message.append(String.format(
                        "- [%s](%s) - %s\n",
                        commit.get("id").asText().substring(0, 7), // 짧은 커밋 해시
                        commit.get("url").asText(),
                        commit.get("message").asText()
                    ));
                }
                break;

            case "pull_request":
                // Pull Request 이벤트 처리
                String action = payload.get("action").asText();
                JsonNode pr = payload.get("pull_request");
                message.append(String.format(
                    "### Pull Request %s\n**Title**: %s\n**URL**: %s",
                    action,
                    pr.get("title").asText(),
                    pr.get("html_url").asText()
                ));
                break;

            default:
                // 기타 이벤트 처리
                message.append("Received ").append(eventType).append(" event");
        }

        return message.toString();
    }
}


