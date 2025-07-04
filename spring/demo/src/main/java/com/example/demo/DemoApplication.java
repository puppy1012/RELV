package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    // Lombok, Spring Web 두 개
    // Lombok은 클래스의 Get 매서드와 Set 매서드를 자동화시키기 위해 사용
    // Spring은 Web 서버를 쉽게 개발할 수 있도록 `이런 이런 흐름을 따라가세요` 형태의 프레임워크
    // 프레임워크와 라이브러리의 차이가 있습니다.
    // 프레임워크는 위와 같이 `이런 이런 흐름을 따라가세요` 형태의 소프트웨어
    // 라이브러리는 누군가 만들어 놓은 소프트웨어
    // 그래서 쉽게 웹 서버를 만들자는 것이 핵심이라 보면 됩니다.
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // Spring을 구동하면 `Tomcat started on port 8080 (http)` <- 요런 메시지가 나옵니다.
    // 8080은 포트 번호이며 기본값으로 할당되어 있습니다.
    // 포트 번호는 주소 같은 것이라 봐야합니다.
    // 집 주소 작성시 `x시 y구 z동` 형태를 작성하며
    // 상세 주소에 `k아파트 i동 j호` 작성을 할 것입니다.
    // 여기서 `IP번호`는 `x시 y구 z동` 을 의미합니다 <- 혼자 사용할 땐 `localhost` 로 대체할 수 있습니다.
    // PORT(포트) 번호는 `k아파트 i동 j호` 에 해당하는 상세 주소입니다.

    // 그래서 우리가 현재 구동되는 Spring 서버에 접속하려면
    // 웹 브라우저를 키고 http://localhost:8080 하면 됩니다.
    // http://{IP번호}:{PORT(포트)번호}
    // HTTP(웹) 방식으로 `x시 y구 z동` 가서 `k아파트 i동 j호` 로 가주세요.
}
