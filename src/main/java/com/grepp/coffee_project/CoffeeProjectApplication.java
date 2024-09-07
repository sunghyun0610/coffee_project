package com.grepp.coffee_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing  // JPA Auditing 활성화
public class CoffeeProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeProjectApplication.class, args);
    }

}
/*
* @SpringBootApplication은 다음 세 가지 어노테이션을 조합한 복합 어노테이션입니다:

1.@SpringBootConfiguration

Spring의 설정 클래스를 나타내는 어노테이션입니다.
내부적으로 @Configuration과 동일한 역할을 하며, 이 어노테이션이 붙은 클래스는 Spring의 설정 클래스로 간주되어 빈(Bean)을 정의할 수 있습니다.
이 클래스 내에서 메서드를 정의하면, 그 메서드를 통해 빈을 등록할 수 있습니다.

@EnableAutoConfiguration
2.Spring Boot의 핵심 기능 중 하나인 **자동 구성(Auto Configuration)**을 활성화하는 어노테이션입니다.
Spring Boot는 이 어노테이션을 통해, 클래스패스에 있는 라이브러리들을 보고 자동으로 설정을 구성합니다. 예를 들어, spring-boot-starter-data-jpa 의존성이 있으면 JPA 관련 설정을 자동으로 구성합니다.
기본적으로 많은 설정이 자동으로 처리되기 때문에, 개발자는 설정 파일을 최소한으로 작성해도 애플리케이션을 실행할 수 있습니다.

@ComponentScan
3.스프링 컴포넌트 스캔을 활성화하는 어노테이션입니다.
기본적으로 @Component, @Service, @Controller, @Repository와 같은 어노테이션이 붙은 클래스를 찾아서 Spring 컨텍스트에 빈으로 등록합니다.
@SpringBootApplication이 선언된 패키지와 그 하위 패키지에서 컴포넌트를 자동으로 스캔합니다.
* */