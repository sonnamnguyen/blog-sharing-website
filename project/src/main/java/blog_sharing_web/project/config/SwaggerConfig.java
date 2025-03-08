package blog_sharing_web.project.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import java.util.List;

@Configuration
@Profile({"dev"})
public class SwaggerConfig {

    @Value("${openapi.service.api-docs}")
    private String apiDocs;

    @Value("${openapi.service.title}")
    private String title;

    @Value("${openapi.service.version}")
    private String version;

    @Value("${openapi.service.server}")
    private String serverUrl;

    @Bean
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder()
                .group(apiDocs)
                .packagesToScan("blog-sharing-website.project")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
//        final String securityScheme = "bearerAuth";
        return new OpenAPI()
                .servers(List.of(new Server().url(serverUrl)))
//                .components(new Components()
//                        .addSecuritySchemes(
//                                securityScheme, new SecurityScheme()
//                                        .type(SecurityScheme.Type.HTTP)
//                                        .scheme("bearer")
//                                        .bearerFormat("JWT")
//                        )
//                )
//                .security(List.of(new SecurityRequirement().addList(securityScheme)))
                .info(new Info()
                        .title(title)
                        .description("API documents for Backend Bloggang  service")
                        .version(version)
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")));
    }
}
