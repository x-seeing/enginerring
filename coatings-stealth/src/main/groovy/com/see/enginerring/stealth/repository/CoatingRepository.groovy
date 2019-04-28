package com.see.enginerring.stealth.repository

import com.see.enginerring.stealth.Coating
import org.bson.types.ObjectId
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.QueryByExampleExecutor
import org.springframework.stereotype.Repository

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Repository
interface CoatingRepository extends CrudRepository<Coating, ObjectId>, QueryByExampleExecutor<Thruster> {


}
