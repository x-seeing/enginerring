package com.see.enginerring.baicm.repository

import com.see.enginerring.baicm.domain.Channel
import org.bson.types.ObjectId
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.QueryByExampleExecutor
import org.springframework.stereotype.Repository

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Repository
interface ChannelRepository extends CrudRepository<Channel, ObjectId>, QueryByExampleExecutor<Channel> {

    Channel findFirstByChannelCode(String channelCode)

}
