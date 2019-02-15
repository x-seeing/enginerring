package com.see.misc.common.web

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.ObjectFactory
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Slf4j
class PrincipalObjectFactory implements ObjectFactory<IPrincipal>, Serializable {

    @Override
    IPrincipal getObject() {
        def requestAttr = RequestContextHolder.currentRequestAttributes()
        if (!(requestAttr instanceof ServletRequestAttributes)) {
            throw new IllegalStateException('Current request is not a servlet request')
        }
        def request = requestAttr.getRequest()
        def p = new PrincipalHelper(request).get()

        new IPrincipal() {

            @Override
            IPrincipal get() {
                p
            }
        }
    }

    @Override
    String toString() {
        'Current principal'
    }

}
