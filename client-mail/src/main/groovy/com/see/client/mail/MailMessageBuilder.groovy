package com.see.client.mail

import groovy.transform.builder.Builder
import groovy.transform.builder.DefaultStrategy
import org.springframework.mail.SimpleMailMessage

/**
 * 任晓燕
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Builder(builderStrategy = DefaultStrategy, prefix = "with")
class MailMessageBuilder {

    static SimpleMailMessage buildMessage(String subject, String text) {
        new SimpleMailMessage().with {
            it.subject = subject
            it.text = text

            it
        }
    }

}
