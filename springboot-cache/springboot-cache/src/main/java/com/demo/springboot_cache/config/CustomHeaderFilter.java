package com.demo.springboot_cache.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

/*
* This filter is used to add custom header for all the responses
* */
@Component
public class CustomHeaderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Custom-Header", "Custom-Value");

        filterChain.doFilter(servletRequest, response);
    }
}
