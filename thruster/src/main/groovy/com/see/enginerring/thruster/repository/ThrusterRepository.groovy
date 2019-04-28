package com.see.enginerring.thruster.repository

import com.see.enginerring.thruster.domain.Thruster
import org.bson.types.ObjectId
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.QueryByExampleExecutor
import org.springframework.stereotype.Repository

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Repository
interface ThrusterRepository extends CrudRepository<Thruster, ObjectId>, QueryByExampleExecutor<Thruster> {


}
