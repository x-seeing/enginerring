package com.see.misc.common.web

import groovy.util.logging.Slf4j

import javax.servlet.http.HttpServletRequest

import static com.see.misc.common.web.Constants.KEY_SESSION_USER

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Slf4j
class PrincipalHelper {

    private HttpServletRequest request

    PrincipalHelper(HttpServletRequest request) {
        this.request = request
    }

    IPrincipal get() {
        request.getAttribute(KEY_SESSION_USER) as IPrincipal
    }
}
