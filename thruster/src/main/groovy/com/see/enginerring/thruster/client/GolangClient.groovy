package com.see.enginerring.thruster.client

import com.see.enginerring.thruster.domain.Thruster
import org.springframework.stereotype.Component

import static com.see.core.http.Http.getC
import static groovyx.net.http.ContentType.JSON

/**
 * golang client
 * Created by suyaqiang on 2019/9/9.
 */
@Component
class GolangClient {

    private static final SHEKEND_URL = "shekend_url"

    def shekend() {
        getC(SHEKEND_URL).get([
            contentType: JSON,
        ]) { resp, json ->
            json.collect {
                new Thruster([
                    platform: it.platform,
                    code    : it.code,
                    p       : it.p,
                    country : it.country
                ])
            }
        }
    }

}
