package com.see.enginerring.baicm.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Document(collection = "baicm_business_analysis")
@EqualsAndHashCode
@ToString
class BusinessAnalysis {

    String phone

    String channelCode

    List<Map> delta
}
