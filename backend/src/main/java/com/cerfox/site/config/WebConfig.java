package com.cerfox.site.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${app.uploads.dir:./uploads}")
    private String uploadsDir;
    @Value("${app.uploads.url-prefix:/uploads}")
    private String urlPrefix;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String urlPath = Path.of(uploadsDir)
                .toAbsolutePath()
                .normalize()
                .toUri()
                .toString();

        String pattern = urlPrefix.endsWith("/") ? urlPrefix + "**" : urlPrefix + "/**";

        registry.addResourceHandler(pattern)
                .addResourceLocations(urlPath)
                .setCachePeriod(3600);

    }
}