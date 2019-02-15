package com.see.enginerring.efrost.web.resource.chinamobile.mgtv

import groovy.util.logging.Slf4j
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import static com.see.core.business.BusinessCodes.CODE_SUCCESS

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Slf4j
@RestController
@RequestMapping('/efrost/10086')
class DataResource {

    @GetMapping('/phone')
    def phone(@RequestParam String phone) {
        [
            code: CODE_SUCCESS,
            data: null
        ]
    }

    @GetMapping('/code')
    def code(@RequestParam String code) {
        [
            code: CODE_SUCCESS,
            data: null
        ]
    }

    @GetMapping('/buy')
    def buy() {
        [
            code: CODE_SUCCESS,
            data: null
        ]
    }

}

