package com.example.hello;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * MockMVC는 Spring Test에서 제공되며 편리한 빌더 클래스 set을 통해 HTTP 요청을 DispatcherServlet으로 보내고 결과에 대한 assertions을 만들 수 있습니다.
 * MockMVC 인스턴스를 주입하기 위해 `@AutoConfigureMockMVC` 및 `@SpringBootTest`를 사용하는 것에 유의하세요.
 * `@SpringBootTest`를 사용하여 전체 애플리케이션 컨텍스트를 생성하도록 요청합니다.
 * 대안으로 `@WebMvcTest`를 사용하여 컨텍스트의 웹 레이어만 생성하도록 Spring Boot에 요청할 수 있습니다.
 * 두 경우 모두 Spring Boot는 자동으로 애플리케이션의 기본 애플리케이션 클래스를 찾으려고 시도하지만 다른 것을 빋드하려는 경우 이를 재정의하거나 범위를 좁힐 수 있습니다.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello, World!")));
    }
}
