package dev.project.hibernateFilterImplementation.interceptor;

import dev.project.hibernateFilterImplementation.context.CountryContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class CountryInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String country = request.getHeader("X-Country");
        System.out.println("Interceptor country: " + country);

        // Set the context for the current request thread
        CountryContext.setCountry(country == null ? "UAE" : country);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // Clean up the context after the request is complete to prevent memory leaks
        CountryContext.clear();
    }
}