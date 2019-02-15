package com.see.enginerring.efrost.web.controller

import com.see.misc.common.web.IPrincipal
import groovy.transform.Canonical
import groovy.util.logging.Slf4j

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Slf4j
@Canonical
class Principal implements IPrincipal {

    String userName


    @Override
    IPrincipal get() {
        throw UnsupportedOperationException()
    }
}
