package dev.project.hibernateFilterImplementation.config;

import dev.project.hibernateFilterImplementation.interceptor.CountryInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private CountryInterceptor countryInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(countryInterceptor)
                .addPathPatterns("/**");
    }
}
