package com.see.enginerring.thruster.attacker

import com.see.enginerring.thruster.domain.AttackTarget
import com.see.enginerring.thruster.domain.Spoil
import com.see.enginerring.thruster.domain.Thruster
import com.see.enginerring.thruster.patrol.Captor
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component

/**
 * ms编队
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Slf4j
@Component
class MicrosoftAttacker implements Attacker {

    public static final String FORMATION = "microsoft"
    private List<Thruster> thrusters

    @Override
    String formation() {
        FORMATION
    }

    @Override
    List<Spoil> doAttack(AttackTarget target, List<Captor> captors) {

        thrusters.collect { thruster ->
            // 适配出一个captor
            def c = captors.find {
                it.capableOf(thruster.platform)
            }
            def code = c.capture(FORMATION, thruster.p)

            // 提取战利品

        }

        return null
    }

    @Override
    void setThrusters(List<Thruster> thrusters) {
        this.thrusters = thrusters
    }

    @Override
    List<Thruster> getThrusters() {
        this.thrusters
    }

    @Override
    AttackTarget build() {
        new AttackTarget().with {

            it
        }
    }

}
