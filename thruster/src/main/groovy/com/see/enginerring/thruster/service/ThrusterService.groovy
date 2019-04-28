package com.see.enginerring.thruster.service

import com.google.common.eventbus.EventBus
import com.see.enginerring.thruster.domain.Thruster
import com.see.enginerring.thruster.repository.ThrusterRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static org.springframework.data.domain.Example.of

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Slf4j
@Service
class ThrusterService {

    @Autowired
    private ThrusterRepository thrusterRepository

    @Autowired
    private EventBus eventBus

    void sharpen(List<Thruster> thrusters) {
        thrusters.each {
            def existed = thrusterRepository.findOne(of(new Thruster(platform: it.platform, p: it.p)))
            if (!existed.isPresent()) {
                log.info("add {} thruster: {}", it.platform, it.p)
                thrusterRepository.save(it)

                eventBus.post(it)
            } else {
                // TODO 是否需要检查是否可用
            }
        }
    }


}
