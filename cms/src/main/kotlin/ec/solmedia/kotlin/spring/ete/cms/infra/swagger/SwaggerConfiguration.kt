package ec.solmedia.kotlin.spring.ete.cms.infra.swagger

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 *
 */
@Configuration
@EnableSwagger2
class SwaggerConfiguration {

    /**
     * The Docket class is a builder to create an API definition, and it provides sensible defaults and convenience
     * methods for configuration of the Spring Swagger MVC Framework.
     *
     * The invocation of method .apis(...) instructs the framework to handle classes annotated with @RestController
     */
    @Bean
    fun documentation() = Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.withClassAnnotation(RestController::class.java))
        .paths(PathSelectors.any())
        .build()
}