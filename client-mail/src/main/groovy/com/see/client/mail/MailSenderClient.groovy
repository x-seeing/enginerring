package com.see.client.mail

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.MailSender
import org.springframework.mail.SimpleMailMessage
import org.springframework.stereotype.Component

/**
 * 任晓燕 0215
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Slf4j
@Component
class MailSenderClient {

    @Value('${spring.mail.username}')
    private String mailFrom

    @Autowired
    private MailSender sender

    void sender(SimpleMailMessage mail) {
        mail.from = mailFrom
        mail.to = mailFrom

        log.info 'send mail : {}, {}', mail.getSubject(), mail.getText()
        sender.send(mail)
    }

}
