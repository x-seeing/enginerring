package com.see.enginerring.thruster.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * 战利品
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@EqualsAndHashCode
@ToString
class Spoil {

    String platform

    String p

    String type

    Map descriptor // 描述符

}
