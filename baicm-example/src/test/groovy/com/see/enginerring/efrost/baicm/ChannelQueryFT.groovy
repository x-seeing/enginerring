package com.see.enginerring.efrost.baicm

import com.see.client.mongo.MongoClientConf
import com.see.enginerring.baicm.app.config.BaicmAppConf
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@ContextConfiguration(classes = [
    BaicmAppConf,
    MongoClientConf
])
class ChannelQueryFT extends Specification {


    def baicm渠道查询() {

        when:
        1 == 1

        then:
        1

        where:
        a << [1]
    }
}
