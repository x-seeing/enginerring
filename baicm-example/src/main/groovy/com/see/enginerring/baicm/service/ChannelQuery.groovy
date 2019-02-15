package com.see.enginerring.baicm.service

import com.mongodb.BasicDBObject
import com.see.core.http.WithHttp
import com.see.enginerring.baicm.domain.Channel
import com.see.enginerring.baicm.repository.ChannelRepository
import groovy.json.JsonSlurper
import groovy.util.logging.Slf4j
import groovyx.net.http.ContentType
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.stereotype.Service

import javax.annotation.Resource
import java.util.zip.GZIPInputStream

import static com.see.enginerring.baicm.Constant.SERV_ADDR

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Slf4j
@Service
class ChannelQuery extends WithHttp {

    @Resource
    private ChannelRepository channelRepository
    @Resource
    private MongoTemplate mongoTemplate

    def queryByAreaAndStore(range, area) {
        range.collect {
            def channelCode = "${area}${(it as String).padLeft(3, '0')}"
            def c = doQuery channelCode
            if (c) {
                def channel = new Channel(channelCode: channelCode, area: area, data: c.data, sequence: it)
                def existed = channelRepository.findFirstByChannelCode(channelCode)
                if (!existed) {
                    channelRepository.save(channel)
                }
            }
        } - null
    }


    def doQuery(params) {
        http.post([
            contentType: ContentType.BINARY,
            body       : [
                channelCode: params
            ]
        ]) { resp, json_ ->
            InputStream stream = new GZIPInputStream(json_)
            def bs = stream.bytes
            def body = new String(bs)
            def json = new JsonSlurper().parseText(body)
            if (json.data?.channelName) {
                log.info(params + ' | ' + body)
                json
            }
        }
    }

    // 获取最大值+1
    def buildRange(area) {
        def aggregation = Aggregation.newAggregation(
            Aggregation.match(Criteria.where("area").is(area)),
            Aggregation.group("area").max("sequence").as("max")
        )
        def a = mongoTemplate.aggregate(aggregation, "baicm_channel", BasicDBObject)
        def max = a?.getMappedResults() ? a?.getMappedResults()?.get(0)?.get('max') : null
        max ? ((max + 1)..(max + 1)) : (0..0)
    }


    @Override
    String getUrl() {
        "$SERV_ADDR/app_member/querySysMemberSourceByChannelCode"
    }

    @Override
    Map getHeaders() {
        [
            'Accept'          : 'application/json, text/javascript, */*; q=0.01',
            'Content-Type'    : 'application/x-www-form-urlencoded; charset=UTF-8',
            'Origin'          : SERV_ADDR,
            'X-Requested-With': 'XMLHttpRequest',
        ]
    }
}
