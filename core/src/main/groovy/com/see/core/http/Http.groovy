package com.see.core.http

import groovyx.net.http.RESTClient

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
class Http {

    static RESTClient getC(url) {
        new RESTClient(url)
    }

    static RESTClient getProxyC(url, schema = 'http') {
        def c = new RESTClient(url)
        c
    }

}
