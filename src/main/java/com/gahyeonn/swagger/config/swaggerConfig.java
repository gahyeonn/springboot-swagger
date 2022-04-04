package com.gahyeonn.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class swaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30) //swagger 설정의 핵심이 되는 Bean
                .useDefaultResponseMessages(false) //swagger에서 기본으로 제공해주는 응답 코드를 노출하지 않음
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gahyeonn.swagger.controller")) //api 스펙이 작성되어 있는 패키지(Controller)를 지정
                .paths(PathSelectors.any()) //apis에 있는 API 중 특정 path를 선택
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() { //Swagger UI로 노출할 정보
        return new ApiInfoBuilder()
                .title("Swagger 연습")
                .description("Swagger 연습 config")
                .version("1.0")
                .build();
    }
}

