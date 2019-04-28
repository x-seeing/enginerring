package com.see.enginerring.stealth.app.config

import com.see.enginerring.core.bundle.BundleConf
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.scheduling.annotation.EnableScheduling

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Configuration
@EnableAutoConfiguration
@Import([BundleConf])
@ComponentScan('com.see.enginerring.stealth')
@EnableMongoRepositories('com.see.enginerring.stealth.repository')
@EnableCaching
@EnableScheduling
class StealthAppConf {

}
