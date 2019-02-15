package com.see.enginerring.efrost.web.resource.baicm

import com.see.enginerring.baicm.domain.Product
import com.see.enginerring.baicm.repository.ProductRepository
import com.see.enginerring.baicm.service.CouponTakeService
import groovy.util.logging.Slf4j
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import javax.annotation.Resource

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Slf4j
@RestController
@RequestMapping('/efrost/baicm/product')
class ProductResource {

    @Resource
    private ProductRepository productRepository
    @Resource
    private CouponTakeService couponTakeService

    @GetMapping('/{channelCode}/buy')
    def take(@PathVariable String channelCode, @RequestParam String p, @RequestParam String code) {
    }

    @PostMapping('/add')
    def add(@RequestBody Product product) {
    }

    @GetMapping('/list')
    def list() {
    }

}

