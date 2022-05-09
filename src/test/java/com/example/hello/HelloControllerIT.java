package com.example.hello;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * HTTP 요청 주기를 mocking 뿐만 아니라, Spring Boot를 사용하여 간단한 전체 스택 통합 테스트를 작성할 수도 있습니다.
 * 임베디드 서버는 `webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT`로 인해 임의의 포트에서 시작되며 실제 포트는 `TestRestTemplate`의 기본 URL에 자동으로 설정됩니다.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/", String.class);
        assertThat(response.getBody()).isEqualTo("Hello, World!");
    }
}