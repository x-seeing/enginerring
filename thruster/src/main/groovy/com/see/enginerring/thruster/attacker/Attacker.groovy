package com.see.enginerring.thruster.attacker

import com.see.enginerring.thruster.domain.AttackTarget
import com.see.enginerring.thruster.domain.Spoil
import com.see.enginerring.thruster.domain.Thruster
import com.see.enginerring.thruster.patrol.Captor
import com.see.enginerring.thruster.patrol.Formation

/**
 * 攻击机
 * 自导自演的美国式战争，自己构建目标并进行攻击
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
interface Attacker extends Formation, TargetBuilder {

    List<Spoil> doAttack(AttackTarget target, List<Captor> captors)

    void setThrusters(List<Thruster> thrusters)

    List<Thruster> getThrusters()

}
