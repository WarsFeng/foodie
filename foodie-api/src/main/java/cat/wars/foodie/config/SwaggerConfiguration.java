package cat.wars.foodie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: foodie
 * @description: springfox-swagger2 config
 * @author: Wars
 * @created: 2019/12/22 02:02
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cat.wars.foodie.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("食品商城系统接口 API")
                .contact(new Contact("Wars", "https://blog.wars.cat", "huangrongfeng1999@gmail.com")) //Contact
                .description("专为食品商城系统提供的 API 文档")
                .version("1.0.0")
                .termsOfServiceUrl("https://foodie.wars.cat")
                .build();
    }
}
