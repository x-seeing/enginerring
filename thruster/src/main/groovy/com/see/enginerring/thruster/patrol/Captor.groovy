package com.see.enginerring.thruster.patrol

import com.see.enginerring.thruster.domain.Capture

/**
 * 收割者
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
interface Captor {

    /**
     * 收割
     */
    List<Capture> capture(String key, String p)

    Boolean capableOf(String platform)

}
