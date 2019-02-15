package com.see.enginerring.efrost.web.controller

import com.see.enginerring.efrost.app.config.AuthProperties
import com.see.misc.common.web.Constants
import com.see.misc.common.web.IPrincipal
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpSession

import static com.see.core.business.BusinessCodes.AUTH_FAILED
import static com.see.core.business.BusinessCodes.CODE_SUCCESS

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Slf4j
@RestController
@RequestMapping('/api/auth')
class AuthController {

    @Autowired(required = false)
    IPrincipal principal

    @Autowired
    private AuthProperties authProperties

    @Autowired(required = false)
    HttpSession session

    @GetMapping('/login')
    def login(@RequestParam String userName, @RequestParam String password) {
        log.info("user : {} try login", userName)

        if (authProperties.password.equals(password)) {
            this.onSuccess(new Principal(userName))
            log.info('user : {} login success', userName)
            [
                code: CODE_SUCCESS,
            ]
        } else {
            [code: AUTH_FAILED]
        }
    }

    @GetMapping('/logout')
    def logout() {
        def userName = session.getAttribute(Constants.KEY_SESSION_USER)
        if (userName) {
            log.info "user : {} try logout", userName
        }
        session.removeAttribute(Constants.KEY_SESSION_USER)
    }

    private onSuccess(p) {
        session.setAttribute(Constants.KEY_SESSION_USER, p)
    }

}
