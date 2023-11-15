package com.github.isarang.sb3.config;

import com.github.isarang.sb3.resources.HelloService;
import com.github.isarang.sb3.resources.ReverseService;
import io.swagger.v3.jaxrs2.integration.JaxrsOpenApiContextBuilder;
import io.swagger.v3.jaxrs2.integration.resources.AcceptHeaderOpenApiResource;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.integration.OpenApiConfigurationException;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import jakarta.servlet.ServletConfig;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Context;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(@Context ServletConfig servletConfig) {
        OpenAPI oas = new OpenAPI();
        Info info = new Info()
            .title("Swagger Sample App bootstrap code")
            .description("This is a sample server Petstore server.  You can find out more about Swagger " +
                "at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).  For this sample, " +
                "you can use the api key `special-key` to test the authorization filters.")
            .termsOfService("http://swagger.io/terms/")
            .contact(new Contact()
                .email("apiteam@swagger.io"))
            .license(new License()
                .name("Apache 2.0")
                .url("http://www.apache.org/licenses/LICENSE-2.0.html"));

        oas.info(info);
        SwaggerConfiguration oasConfig = new SwaggerConfiguration()
            .openAPI(oas)
            .prettyPrint(true)
            .resourcePackages(Stream.of("com.github.isarang.sb3.resources").collect(Collectors.toSet()));


        try {
            new JaxrsOpenApiContextBuilder()
                .servletConfig(servletConfig)
                .application(this)
                .openApiConfiguration(oasConfig)
                .buildContext(true);
        } catch (OpenApiConfigurationException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        register(HelloService.class);
        register(ReverseService.class);
        register(OpenApiResource.class);
        register(AcceptHeaderOpenApiResource.class);
    }

}