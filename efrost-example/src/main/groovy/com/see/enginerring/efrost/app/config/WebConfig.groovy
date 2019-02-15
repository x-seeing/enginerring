package com.see.enginerring.efrost.app.config

import com.see.enginerring.efrost.auth.filter.AuthFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Configuration
class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AuthProperties authProperties

    @Override
    void addInterceptors(InterceptorRegistry registry) {
        def authFilter = new AuthFilter(authProperties.auth, authProperties.escapeAuthUrls)
        registry.addInterceptor(authFilter).addPathPatterns('/**')
    }

    @Override
    void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("PUT", "DELETE", "GET", "POST")
            .allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept", "Accept-Encoding", "City")
            .allowCredentials(true).maxAge(3600)
    }
}
