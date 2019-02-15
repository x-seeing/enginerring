package com.see.audit.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.stereotype.Component

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Component
class AuditService {

    @Autowired
    private AuditRepository auditRepository

    Audit add(Audit audit) {
        auditRepository.save(audit)
    }

    List<Audit> list(Audit example) {
        auditRepository.findAll(Example.of(example)).collect {
            it
        }
    }

}
