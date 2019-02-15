package com.see.enginerring.chrome.example

import com.see.enginerring.chrome.example.app.config.ChromeExampleAppConf
import com.see.enginerring.chrome.example.service.ChromeExampleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by suyaqiang on 2018/12/18.
 */
@SpringBootTest
@ContextConfiguration(classes = [
    ChromeExampleAppConf
])
class LoadPageFT extends Specification {

    @Autowired
    private ChromeExampleService login


    def query() {
        when:
        login.loadPage()

        1 == 1

        then:
        1

        where:
        a << [1]
    }
}
