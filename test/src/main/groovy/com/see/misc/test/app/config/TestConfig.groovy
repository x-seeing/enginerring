package com.see.misc.test.app.config

import com.sun.jersey.api.client.Client
import com.sun.jersey.client.apache4.ApacheHttpClient4Handler
import groovyx.net.http.RESTClient
import org.apache.http.client.config.RequestConfig
import org.apache.http.impl.client.BasicCookieStore
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Configuration
class TestConfig {

    @Bean
    RestTemplate restTemplate() {
        new RestTemplateBuilder().build()
    }

    @Bean
    RESTClient restClient() {
        new RESTClient("http://192.168.100.10").with {
            it
        }
    }

    @Bean
    Client client() {
        def poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager()
        poolingHttpClientConnectionManager.setMaxTotal(200)
        CloseableHttpClient closeableHttpClient = HttpClients.custom()
            .setConnectionManager(poolingHttpClientConnectionManager)
            .setDefaultRequestConfig(RequestConfig.custom().setConnectionRequestTimeout(10000).setSocketTimeout(10000).build())
            .build()

        new Client(new ApacheHttpClient4Handler(closeableHttpClient, new BasicCookieStore(), true))
    }


}
