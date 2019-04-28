package com.see.enginerring.thruster.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.springframework.data.mongodb.core.mapping.Document

/**
 * 挂载
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Document(collection = "thruster")
@EqualsAndHashCode
@ToString
class Thruster {

    String platform

    String code

    String p

    String country

    String useful

    Date time

    List<Capture> captures

}
