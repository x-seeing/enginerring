package com.see.enginerring.thruster.patrol

import com.see.enginerring.thruster.domain.Capture
import groovy.util.logging.Slf4j

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Slf4j
class PatrolSupport {

    static String fetchCode(String content) {
        def m = content =~ /(\d{4,6})/
        if (m.size() > 0) {
            m[0][1]
        }
    }

    static Capture buildCapture(key, p, content) {
        new Capture([
            p      : p,
            key    : key,
            content: content,
            code   : fetchCode(content)
        ])
    }

}
