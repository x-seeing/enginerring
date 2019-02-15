package com.see.enginerring.baicm.patrol

import com.see.client.mail.MailSenderClient
import com.see.enginerring.baicm.service.ChannelQuery
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

import static com.see.client.mail.MailMessageBuilder.buildMessage
import static com.see.enginerring.baicm.Constant.AREAS

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Slf4j
@Component
class Patrol {

    @Autowired
    private MailSenderClient mailSenderClient
    @Autowired
    private ChannelQuery channelQuery

    @Scheduled(cron = '0 0 0,2,22 * * ?')
    void patrol() {
        AREAS.collect { area ->
            def range = channelQuery.buildRange(area)
            def c = channelQuery.queryByAreaAndStore(range, area)
            if (c) {
                log.info("发现新渠道:{}", c.channelCode)
                mailSenderClient.sender(buildMessage("新渠道" + c.channelCode, c.toString()))
            }
        }
    }

}
