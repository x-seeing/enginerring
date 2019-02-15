package com.see.enginerring.chrome.example.app.config

import com.see.enginerring.core.bundle.BundleConf
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Configuration
@EnableAutoConfiguration
@Import([BundleConf])
@ComponentScan('com.see.enginerring.chrome.example')
@EnableMongoRepositories('com.see.chrome.example.*.repository')
class ChromeExampleAppConf {


}
