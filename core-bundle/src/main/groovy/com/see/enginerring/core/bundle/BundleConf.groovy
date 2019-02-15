package com.see.enginerring.core.bundle

import com.see.audit.config.AuditConf
import com.see.client.mail.MailClientConf
import com.see.client.mongo.MongoClientConf
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Configuration
@Import([MailClientConf, MongoClientConf, AuditConf])
class BundleConf {
}
