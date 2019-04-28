package com.see.enginerring.thruster.app.config

import com.google.common.eventbus.AsyncEventBus
import com.google.common.eventbus.EventBus
import com.see.enginerring.core.bundle.BundleConf
import com.see.enginerring.thruster.listener.ThrusterListener
import com.see.enginerring.thruster.patrol.ThrusterPatrolBus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

import java.util.concurrent.Executor

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Configuration
@EnableAutoConfiguration
@Import([BundleConf])
@ComponentScan('com.see.enginerring.thruster')
@EnableMongoRepositories('com.see.enginerring.thruster.repository')
@EnableCaching
@EnableScheduling
class ThrusterAppConf {

    @Autowired
    private ThrusterPatrolBus patrolBus

    @Scheduled(cron = '0 */30 * * * ?')
    void patrol() {
        patrolBus.start()
    }

    @Bean
    EventBus eventBus(Executor executor) {
        new AsyncEventBus(executor).with {
            it.register(new ThrusterListener())
            it
        }
    }

    @Bean
    Executor executor() {
        def executor = new ThreadPoolTaskExecutor()
        executor.setCorePoolSize(5)
        executor.setMaxPoolSize(100)
        executor.setQueueCapacity(10000)
        executor
    }

}
