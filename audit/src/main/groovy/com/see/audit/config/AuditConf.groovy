package com.see.audit.config

import com.mongodb.MongoClient
import com.mongodb.ServerAddress
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDbFactory
import org.springframework.data.mongodb.core.SimpleMongoDbFactory
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Configuration
@EnableMongoRepositories(basePackages = 'com.see.audit')
@ComponentScan("com.see.audit")
class AuditConf {

    // TODO 多数据源配置
    MongoDbFactory mongoDbFactory() {
        def serverAddress = new ServerAddress("localhost", 27017)
        new SimpleMongoDbFactory(new MongoClient(serverAddress), "audit")
    }


}
