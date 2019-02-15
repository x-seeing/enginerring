package com.see.client.cassandra

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Configuration
@PropertySource('cassandra-conf.yml')
class CassandraClient {
}
