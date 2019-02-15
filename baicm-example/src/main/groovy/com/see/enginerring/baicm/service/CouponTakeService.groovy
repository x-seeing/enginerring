package com.see.enginerring.baicm.service

import com.see.audit.config.Audit
import com.see.audit.config.AuditService
import com.see.core.exception.CodeErrorException
import com.see.core.exception.CodeInvalidException
import com.see.core.http.Http
import com.see.core.http.WithHttp
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service

import javax.annotation.Resource

import static com.see.enginerring.baicm.Constant.SERV_ADDR

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Slf4j
@Service
class CouponTakeService extends WithHttp {

    @Resource
    AuditService auditService

    def take(phone, code, channelCode, tryFlag = false) {
        http.post([body: [
            code  : code,
            phone : phone,
            source: channelCode
        ]]) { _r, json ->
            if (json.message?.contains('验证码已失效')) {
                throw new CodeInvalidException('验证码已失效')
            }
            if (json.message?.contains('验证码错误')) {
                throw new CodeErrorException('验证码错误')
            }
            if (tryFlag) {
                if (!json.message?.contains('该渠道已失效，')) {
                    log.info '领取 try -- {} | {}', channelCode, json
                    return new Tuple2(channelCode, json)
                } else {
                    log.info '领取 try failure -- {} | {}', channelCode, json
                }
            } else {
                if (json.message?.contains('成功')) {
                    log.info '领取 take -- {} | {}', channelCode, json
                    json.status = '0'
                } else {
                    json.status = '400'
                    log.info '领取 take failed-- {} | {}', channelCode, json
                }
                // 领取成功 进入审计
                auditService.add(buildAudit(phone, channelCode, json, json.status))
                return new Tuple2(channelCode, json)
            }
        }
    }

    def getMyCode(my) {
        def c = Http.getProxyC("$SERV_ADDR/app_member/")
        def uuid = c.post([
            path: 'getSignRandom'
        ]) { _r, json ->
            json.uuid
        }

        c.post([
            path: 'generaterCode',
            body: [
                phone     : my,
                source    : 'ZMT100210',
                operatorId: 1002,
                signRandom: uuid
            ]
        ]) { _r, json ->
            log.info(json.toString())
            json.success
        }
    }

    @Override
    String getUrl() {
        "$SERV_ADDR/app_member/doRegistByActivity"
    }

    @Override
    Map getHeaders() {
        [:]
    }

    private static Audit buildAudit(phone, channelCode, result, type) {
        new Audit(
            title: 'baicm coupon take',
            platform: 'baicm',
            type: type,
            factMaster: phone,
            fact: channelCode,
            conent: "$phone --> $channelCode : $result",
            createTime: new Date()
        )
    }

}

