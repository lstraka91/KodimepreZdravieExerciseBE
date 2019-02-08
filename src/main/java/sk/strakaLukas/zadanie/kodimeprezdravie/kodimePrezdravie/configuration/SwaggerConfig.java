package sk.strakaLukas.zadanie.kodimeprezdravie.kodimePrezdravie.configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any()).paths(paths())
                .build()
                .apiInfo(apiInfo())
                ;
    }

    private Predicate<String> paths() {
        return Predicates.not(PathSelectors.regex("/error.*|/doc.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Kodime pre zdravie API", "Ukazkove zadanie k pohovoru", "v0.1", null,
                new Contact("Lukas Straka", "", "lstraka91@gmail.com"), null, null, new ArrayList<>());
    }
}
