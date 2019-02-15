package com.see.enginerring.baicm.service

import com.see.enginerring.baicm.Constant
import com.see.enginerring.baicm.domain.BusinessAnalysis
import com.see.enginerring.baicm.repository.BusinessAnalysisRepository
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service

import javax.annotation.Resource

import static com.see.core.http.Http.getProxyC

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Slf4j
@Service
class BusinessAnalysisService {

    @Resource
    BusinessAnalysisRepository businessAnalysisRepository

    def save(BusinessAnalysis businessAnalysis) {
        businessAnalysisRepository.save(businessAnalysis)
    }

    def analysis(token, prev) {
        def c = getProxyC("$Constant.API_ADDR/app/coupon/v1/list")
        c.setHeaders([
            'Authorization': token,
            'appVersion'   : '5.0.2',
            'operatorId'   : '1002',
            'mobileSystem' : 'iOS',
        ])

        c.get([:]) { _r, json ->
            def delta
            if (prev.modelData?.size() != json.modelData?.size()) {
                delta = json.modelData - prev.modelData
                log.info '领取到新券： {}', delta
            }
            log.info '当前券： {}', json
            new Tuple2(json, delta)
        }
    }

}
