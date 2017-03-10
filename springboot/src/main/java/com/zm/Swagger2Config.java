package com.zm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * http://localhost:8080/swagger-ui.html 访问路径
 * Created by zouming on 17-3-10.
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.zm"))
            .paths(PathSelectors.any())
            .build();

    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
            .title("springboot test case apis.")
            .description("springboot test case.")
            .termsOfServiceUrl("http://www.jianshu.com/p/8033ef83a8ed")
            .contact("zm")
            .version("1.0.0")
            .build();
    }
}
