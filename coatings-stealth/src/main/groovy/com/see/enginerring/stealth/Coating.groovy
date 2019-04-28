package com.see.enginerring.stealth

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.springframework.data.mongodb.core.mapping.Document

/**
 * 涂层
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Document(collection = "coating")
@EqualsAndHashCode
@ToString
class Coating {

    String host

    String p

    int level

    Date time

}
