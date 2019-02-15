package com.see.enginerring.chrome.example.mgtv.service

import com.see.enginerring.chrome.WithChrome
import geb.Browser
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Slf4j
@Service
class ChromeExampleService extends WithChrome {

    String loadPage() {
        open()
        log.debug('open the browser finished')
        Browser.drive(browser) {
            go "https://shop112990768.taobao.com/"
        }
    }

    String done() {
        browser.quit()
        log.info('browser quit')
    }

}
