package com.see.enginerring.thruster

import com.see.client.mongo.MongoClientConf
import com.see.enginerring.thruster.app.config.ThrusterAppConf
import com.see.enginerring.thruster.patrol.ShekendPatrol
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@ContextConfiguration(classes = [
    ThrusterAppConf,
    MongoClientConf
])
@SpringBootTest
class PatrolFT extends Specification {

    @Autowired
    private ShekendPatrol shejiinnPatrol

    @Autowired

    def p() {

        when:
        1 == 1

        then:
        shejiinnPatrol.patrol()


        println f
        where:
        a << [1]

    }
}
