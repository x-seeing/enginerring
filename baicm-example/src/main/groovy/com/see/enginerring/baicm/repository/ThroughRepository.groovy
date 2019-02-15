package com.see.enginerring.baicm.repository

import com.see.enginerring.baicm.domain.Through
import org.bson.types.ObjectId
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.QueryByExampleExecutor
import org.springframework.stereotype.Repository

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Repository
interface ThroughRepository extends CrudRepository<Through, ObjectId>, QueryByExampleExecutor<Through> {

    List<Through> findByChannelCodeLike(String channelCode)

    List<Through> findAll()

}
