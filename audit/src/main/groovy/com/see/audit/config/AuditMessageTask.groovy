package com.see.audit.config

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component

import javax.annotation.Resource
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.TimeUnit

import static java.util.concurrent.Executors.newScheduledThreadPool

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Slf4j
@Component
class AuditMessageTask {

    @Resource
    AuditService auditService

    private static final int QUEUE_LENGTH = 1000
    private queue = new LinkedBlockingQueue<Audit>(QUEUE_LENGTH)

    AuditMessageTask() {
        execute()
    }

    void addQueue(Audit audit) {
        queue.add(audit)
    }

    void execute() {
        newScheduledThreadPool(1).scheduleWithFixedDelay({
            try {
                Audit a = queue.take()
                log.info('consume : {}', a)
                auditService.add(a)
            } catch (InterruptedException e) {
                log.error('consume failed', e)
            }
        } as Runnable, 10, 2, TimeUnit.SECONDS)
    }
}
