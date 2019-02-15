package com.see.misc.common.utils.web

import org.jasypt.encryption.StringEncryptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@RestController
@RequestMapping('/u/encrypt')
class EncryptController {

    @Autowired
    private StringEncryptor stringEncryptor

    String encrypt(String salt, String text) {
        stringEncryptor
    }

}
