package com.see.enginerring.efrost.auth.filter

import groovy.transform.InheritConstructors
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import static com.see.misc.common.web.Constants.KEY_SESSION_USER

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@InheritConstructors
class AuthFilter extends HandlerInterceptorAdapter {

    private boolean shouldAuth
    private List<String> escapeAuthUrls

    AuthFilter(boolean shouldAuth, List<String> escapeAuthUrls) {
        this.shouldAuth = shouldAuth
        this.escapeAuthUrls = escapeAuthUrls
    }

    private boolean urlShouldAuth(url) {
        !escapeAuthUrls.contains(url)
    }

    @Override
    boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!shouldAuth) {
            return true
        }
        if (urlShouldAuth(request.getRequestURI())) {
            if (!request.getSession(false) ||
                !request.getSession().getAttribute(KEY_SESSION_USER)) {
                return false
            }
        }
        return true
    }


}
