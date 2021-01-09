package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// 스프링부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정.
// 이 어노테이션부터 어플리케이션을 읽어가기 때문에, 항상 프로젝트 최상단에 위치해야 한다.
@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 내장 WAS를 구동.
        // 별도의 톰캣 구동 없이 jar 파일을 실행하면 된다.
        // 언제 어디서나 같은 환경에서 스프링 부트를 배포할 수 있게 된다.
        SpringApplication.run(Application.class, args);
    }
}
