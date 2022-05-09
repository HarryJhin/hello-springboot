package com.example.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController로 지정된 클래스는 웹 요청을 처리하기 위해 SpringMVC에서 사용할 준비가 되었음을 의미합니다.
 * RestContoller는 Controller와 RespoenBody가 결합한 것입니다.
 * Controller와 RespoenBody는 웹 요청이 view가 아닌 데이터를 반환하도록 하는 어노테이션입니다.
 */
@RestController
public class HelloController {

    /**
     * GetMapping은 /를 index() 메서드에 매핑합니다.
     * 브라우저에서 호출하거나 명령줄에서 curl을 사용하여 호출하면 "Hello, World!" 문자열을 반환합니다.
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "Hello, World!";
    }
}
