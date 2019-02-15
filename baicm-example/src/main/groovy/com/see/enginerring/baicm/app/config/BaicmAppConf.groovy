package com.see.enginerring.baicm.app.config

import com.see.enginerring.core.bundle.BundleConf
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.concurrent.ConcurrentMapCache
import org.springframework.cache.support.SimpleCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.scheduling.annotation.EnableScheduling

import static java.util.Collections.singletonList

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Configuration
@EnableAutoConfiguration
@Import([BundleConf])
@ComponentScan('com.see.enginerring.baicm')
@EnableMongoRepositories('com.see.enginerring.baicm.repository')
@EnableCaching
@EnableScheduling
class BaicmAppConf {

    @Bean
    CacheManager cacheManager() {
        CacheManager cacheManager = new SimpleCacheManager()
        cacheManager.setCaches(singletonList(new ConcurrentMapCache("baicm-channel-cache")))
        return cacheManager
    }

}
