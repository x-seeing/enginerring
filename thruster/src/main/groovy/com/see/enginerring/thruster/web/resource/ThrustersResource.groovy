package com.see.enginerring.thruster.web.resource

import com.see.enginerring.thruster.domain.Thruster
import com.see.enginerring.thruster.service.AttackPlaneService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@RestController
@RequestMapping('thrusters')
class ThrustersResource {

    @Autowired
    AttackPlaneService attackPlaneService

    @GetMapping('takeoff')
    List<Thruster> takeoff(@RequestParam(required = false) String platform) {

        attackPlaneService.takeoff(platform)

    }

    @GetMapping('capture')
    String capture(@RequestParam String platform, @RequestParam String p) {

        attackPlaneService.capture(platform, p)

    }

}
