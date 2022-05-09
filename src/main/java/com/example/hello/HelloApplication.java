package com.example.hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * `@SpringBootApplication`은 다음을 모두 추가하는 편리한 어노테이션입니다.
 * `@Configuration`: 애플리케이션 컨텍스트에 대한 Bean 정의 소스로 클래스에 태그를 지정합니다.
 * `@EnableAutoConfiguration`: Spring Boot에 클래스 경로 설정, 기타 빈 및 다양한 속성 설정을 기반으로 Bean 추가를 시작하도록 지시합니다.
 * `@ComponentScan`: com/example 패키지에서 다른 구성 요소, 구성 및 서비스를 찾도록 Spring에 지시하여 Controller를 찾도록 합니다.
 */
@SpringBootApplication
public class HelloApplication {

    /**
     * main() 메서드는 Spring Boot의 SpringApplication.run() 메서드를 사용하여 애플리케이션을 시작합니다.
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

    /**
     * `@Bean`으로 표시된 CommandLineRunner() 메서드는 애플리케이션 시작 시 실행됩니다.
     * 애플리케이션에서 생성했거나 Spring Boot에 의해 자동으로 추가된 모든 Bean을 검색합니다.
     * 검색한 Bean을 정렬하고 출력합니다.
     * @param ctx ApplicationContext
     * @return bean 목록들
     */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("'Spring'에서 제공하는 'Bean'에 대해 알아보자:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }
}