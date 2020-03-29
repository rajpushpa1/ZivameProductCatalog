package com.zivame.zivame.config;


import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        // @formatter:off
        //Register the controllers to swagger
        //Also it is configuring the Swagger Docket
        return new Docket(DocumentationType.SWAGGER_2).select()
                // .apis(RequestHandlerSelectors.any())
                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                // .paths(PathSelectors.any())
                // .paths(PathSelectors.ant("/swagger2-demo"))
                .build();
        // @formatter:on
    }

//    private Predicate<String> postPaths() {
//        return or(regex("/api/posts.*"), regex("/api/javainuse.*"));
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Zivame API")
                .description(" API reference for developers")
                .termsOfServiceUrl("http://test.com")
                .contact("test@gmail.com").license("My License")
                .licenseUrl("test@gmail.com").version("1.0").build();
    }

}
