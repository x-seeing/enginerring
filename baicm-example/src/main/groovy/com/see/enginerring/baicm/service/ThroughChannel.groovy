package com.see.enginerring.baicm.service

import com.see.client.mail.MailSenderClient
import com.see.enginerring.baicm.domain.BusinessAnalysis
import com.see.enginerring.baicm.domain.Channel
import com.see.enginerring.baicm.domain.Through
import com.see.enginerring.baicm.repository.ChannelRepository
import com.see.enginerring.baicm.repository.ThroughRepository
import groovy.util.logging.Slf4j
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Example
import org.springframework.stereotype.Service

import javax.annotation.Resource

import static com.see.client.mail.MailMessageBuilder.buildMessage

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Slf4j
@Service
class ThroughChannel {

    private static
    final String TOKEN = 'MOREFUN_APP_eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjQxNTM5MSIsImV4cCI6MTU0ODY3OTQwNCwiaWF0IjoxNTQ4MDc0NjA0fQ.ZeWHV3wRFjw63DWbc1ayipU3hXduR6TomkpRppIWLbpmCnedri6k8ue8wVROyu4lkMthQeEb6cplpr0i-m8RAA'

    @Resource
    private CouponTakeService couponTakeService
    @Resource
    private ChannelRepository channelRepository
    @Resource
    private ThroughRepository throughRepository
    @Resource
    private BusinessAnalysisService businessAnalysisService
    @Resource
    private MailSenderClient mailSenderClient

    def through(phone, code, areas, biAnalysis = false, token = TOKEN) {
        def prev = [[]]
        def throughChannels = areas.collect { area ->
            def channelsInArea = channelRepository.findAll(Example.of(new Channel(area: area)))
            channelsInArea.collect { channel ->
                def channelCode = channel?.data?.channelCode
                sleep 100
                def takenResult = couponTakeService.take(phone, code, channelCode, true)
                // 商务分析 从用户的列表中查询领取的详情
                if (biAnalysis) {
                    Tuple2 bi = businessAnalysisService.analysis(token, prev)
                    prev = bi.first
                    if (bi.second) {
                        businessAnalysisService.save(new BusinessAnalysis(phone: phone, channelCode: channelCode, delta: bi.second))
                    }
                    log.info 'channelCode :{} | --> delta :{}', channelCode, bi.second
                }
                takenResult
            } - null
        } - null
        def result = throughChannels.inject([]) { r, curr ->
            if (curr) {
                r.addAll(curr)
            }
            r
        }
        result.collect { Tuple2 t ->
            throughRepository.save(new Through(channelCode: t.first, takeResult: t.second))

            // 发送邮件
            if (t?.second?.message?.contains('成功')) {
                sendMailOnSuccess(phone.toString(), t.first.toString(), t.second.toString())
            }
        }
    }

    private sendMailOnSuccess(String p, String channelCode, String message) {
        mailSenderClient.sender(buildMessage(p + "-" + channelCode, message))
    }

    @Cacheable(value = "baicm-channel-cache", key = "#code")
    def getChannelByCode(code) {
        channelRepository.findFirstByChannelCode(code).data
    }
}
