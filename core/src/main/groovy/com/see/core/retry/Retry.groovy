package com.see.core.retry

import groovy.util.logging.Slf4j

/**
 * Created by suyaqiang on 2019/4/25.
 */
@Slf4j
class Retry {

    static withRetry(Integer times, Integer intervalMs, Closure cl) {
        def triedTimes = 0
        for (int i : (0..(times - 1))) {
            if (triedTimes < times) {
                try {
                    return cl()
                } catch (Exception e) {
                    log.debug("caught exception with tried times: " + triedTimes, e)
                } finally {
                    triedTimes++
                    if (intervalMs > 0) {
                        sleep(intervalMs)
                    }
                }
            }
        }
        log.debug("retry with times: {} and ended in failure", times)
    }
}
