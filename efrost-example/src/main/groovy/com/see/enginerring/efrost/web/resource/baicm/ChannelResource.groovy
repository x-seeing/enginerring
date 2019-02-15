package com.see.enginerring.efrost.web.resource.baicm

import com.see.enginerring.baicm.repository.ChannelRepository
import com.see.enginerring.baicm.repository.ThroughRepository
import com.see.enginerring.baicm.service.ChannelQuery
import com.see.enginerring.baicm.service.CouponTakeService
import com.see.enginerring.baicm.service.ThroughChannel
import groovy.util.logging.Slf4j
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import javax.annotation.Resource

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Slf4j
@RestController
@RequestMapping('/efrost/baicm')
class ChannelResource {

    @Resource
    MongoTemplate mongoTemplate
    @Resource
    ChannelQuery channelQuery
    @Resource
    ThroughChannel throughChannel
    @Resource
    CouponTakeService couponTakeService
    @Resource
    ChannelRepository channelRepository
    @Resource
    ThroughRepository throughRepository

    @GetMapping('/channel/screen')
    def screenOut(@RequestParam(required = false) String key, @RequestParam(required = false) String value) {
    }

    @GetMapping('/channel/query')
    def query(@RequestParam(required = false) Boolean shouldInit) {
    }

    @GetMapping('/channel/through')
    def through(@RequestParam p, @RequestParam code, @RequestParam(required = false) String token) {
    }

    @GetMapping('/channel/through/get')
    def getThrough() {
    }


    @GetMapping('/channel/area/{area}/take')
    def takeByArea(@PathVariable String area, @RequestParam String p, @RequestParam(required = false) String code) {
    }

    @GetMapping('/channel/code')
    def getMyCode(@RequestParam String p) {
    }

    @GetMapping('/channel/code/validate')
    def codeValidate(@RequestParam p, @RequestParam code) {
    }

}

