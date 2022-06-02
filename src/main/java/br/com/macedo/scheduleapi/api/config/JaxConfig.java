package br.com.macedo.scheduleapi.api.config;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import io.swagger.jersey.listing.ApiListingResourceJSON;
import io.swagger.models.Swagger;
import io.swagger.models.auth.BasicAuthDefinition;
import org.glassfish.jersey.server.ResourceConfig;
import org.springdoc.api.OpenApiResource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletConfigAware;

import javax.servlet.ServletConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;

@Component
@ApplicationPath("/api")
@Path("/")
public class JaxConfig extends ResourceConfig implements ServletConfigAware {

    private ServletConfig servletConfig;

    public JaxConfig() {
        packages("br.com.macedo.scheduleapi.api.controller");
        register(OpenApiResource.class);
        configureSwagger();
    }

    public void configureSwagger() {

        // localhost:8081/api/swagger.json
        register(ApiListingResourceJSON.class);
        register(SwaggerSerializers.class);

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setTitle("Schedule API");
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/api");
        beanConfig.setPrettyPrint(true);
        beanConfig.setResourcePackage("br.com.macedo.scheduleapi.api.controller");
        beanConfig.setScan(true);

        Swagger swagger = beanConfig.getSwagger();
        swagger.securityDefinition("basicAuth", new BasicAuthDefinition());
        new SwaggerContextService().withServletConfig(servletConfig).updateSwagger(swagger);

    }

    @Override
    public void setServletConfig(ServletConfig servletConfig) {
        this.servletConfig = servletConfig;
    }
}
