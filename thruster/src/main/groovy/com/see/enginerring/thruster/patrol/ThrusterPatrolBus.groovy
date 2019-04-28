package com.see.enginerring.thruster.patrol

import com.see.enginerring.thruster.service.ThrusterService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import static java.util.concurrent.Executors.newWorkStealingPool

/**
 * Created by suyaqiang on 2019/4/26.
 */
@Slf4j
@Component
class ThrusterPatrolBus {

    @Autowired
    private ThrusterService thrusterService

    @Autowired
    private List<Patrol> patrols

    void start() {
        log.info("thruster patrol starting ...")
        def pool = newWorkStealingPool(patrols.size())
        patrols.each { p ->
            pool.submit {
                def thrusters = p.patrol()
                thrusters.collect { t ->
                    t.time = new Date()
                    if (!t.country || '[]' == t.country) {
                        if (t.p.startsWith('86') || t.p.startsWith('+86')) {
                            t.country = '中国'
                        }
                    }
                    t
                }
                thrusterService.sharpen(thrusters)
            }
        }
        log.info("thruster patrol finished ...")
    }

}
