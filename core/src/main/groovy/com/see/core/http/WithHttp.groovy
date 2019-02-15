package com.see.core.http


import groovyx.net.http.RESTClient

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
abstract class WithHttp {

    protected RESTClient http

    WithHttp() {
        init()
    }

    private void init() {
        this.http = Http.getProxyC(url)
        this.http.headers = headers
    }

    protected abstract String getUrl()

    protected abstract Map getHeaders()
}
