package com.see.enginerring.chrome

import geb.Browser

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
abstract class WithChrome {

    protected Browser browser

    Browser open() {
        this.browser = new Browser(driver: Chrome.get())
        this.browser
    }

    void quit() {
        this.browser.close()
    }

}
