package com.see.enginerring.efrost.app.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Component
@ConfigurationProperties("com.see")
class AuthProperties {

    boolean auth

    String password

    List<String> escapeAuthUrls

}
