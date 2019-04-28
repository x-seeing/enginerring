package com.see.enginerring.thruster.listener

import com.google.common.eventbus.Subscribe
import com.see.enginerring.thruster.domain.Thruster
import groovy.util.logging.Slf4j

/**
 * Created by suyaqiang on 2019/4/26.
 */
@Slf4j
class ThrusterListener {

    @Subscribe
    void handle(Thruster thruster) {
        log.info("new thruster come in : {}")
    }
}
