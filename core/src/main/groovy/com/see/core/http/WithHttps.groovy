package com.see.core.http
/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
abstract class WithHttps extends WithHttp {

    WithHttps() {
        super()
        http.ignoreSSLIssues()
    }

}
