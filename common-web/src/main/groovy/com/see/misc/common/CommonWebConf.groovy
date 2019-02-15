package com.see.misc.common

import com.see.misc.common.web.IPrincipal
import com.see.misc.common.web.PrincipalObjectFactory
import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.context.annotation.Configuration

import javax.servlet.ServletContext
import javax.servlet.ServletException

import static org.springframework.web.context.WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Configuration
class CommonWebConf implements ServletContextInitializer {

    @Override
    void onStartup(ServletContext servletContext) throws ServletException {
        def beanFactory = servletContext.getAttribute(ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE).beanFactory
        beanFactory.registerResolvableDependency(IPrincipal, new PrincipalObjectFactory())
    }

}
