package com.see.audit.config

import org.springframework.stereotype.Component

import javax.annotation.Resource

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Component
class AuditMessageSender {

    @Resource
    private AuditMessageTask auditMessageTask

    void send(Audit audit) {
        auditMessageTask.addQueue(audit)
    }


}
