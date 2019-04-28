package com.see.enginerring.thruster.service

import com.see.enginerring.thruster.attacker.Attacker
import com.see.enginerring.thruster.domain.AttackTarget
import com.see.enginerring.thruster.domain.Capture
import com.see.enginerring.thruster.domain.Thruster
import com.see.enginerring.thruster.patrol.Captor
import com.see.enginerring.thruster.repository.ThrusterRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static org.apache.commons.collections.IteratorUtils.toList
import static org.springframework.data.domain.Example.of

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Slf4j
@Service
class AttackPlaneService {

    @Autowired
    private ThrusterRepository thrusterRepository

    @Autowired
    private List<Attacker> attackers

    @Autowired
    private List<Captor> captors

    /**
     * 获取挂载
     */
    List<Thruster> takeoff(String platform) {
        if (platform) {
            toList(thrusterRepository.findAll(of(new Thruster(platform: platform))).iterator())
        } else {
            toList(thrusterRepository.findAll().iterator())
        }
    }

    /**
     * 第几编队，几号机.获取捕获物
     */
    List<Capture> capture(String formation, String p) {
        def captor = captors.find {
            it.capableOf(formation)
        }

        def c = captor.capture(formation, p)
        def retrieved = thrusterRepository.findOne(of(new Thruster(p: '/' + p + '/'))).get()
        if (!retrieved.captures) {
            retrieved.captures = []
        }
        retrieved.captures.addAll(c)
        thrusterRepository.save(retrieved)
        log.info("capture : {}, p:{}, code: {}", formation, p, c.code)

        c
    }

    void doAttack(AttackTarget target) {
        // 1. 提取编队
        def takeoffs = this.takeoff(null)

        // 2. 打击目标
        def spoils = attackers.collect { attacker ->
            attacker.setThrusters(takeoffs)
            def spoils = attacker.doAttack(target, captors)
        }
        // 3. 捕获战利品

        // 4. 清理战场

        // 5 记入战争史册, 简历建立知识库系统，随时翻阅

    }

}
