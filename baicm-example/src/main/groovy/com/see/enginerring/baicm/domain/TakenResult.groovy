package com.see.enginerring.baicm.domain

import groovy.transform.Canonical
import groovy.transform.TupleConstructor

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Canonical
@TupleConstructor
class TakenResult {

    String area
    String message
    String channelCode
    String channelName
    Integer channelType
    String h5TopImg
    String shareTitle
    String shareSubtitle
    Date createTime
    Integer giftId
    Boolean isDelete
    Boolean isDown
}
