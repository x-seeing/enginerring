package com.see.enginerring.chrome

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.springframework.core.io.ClassPathResource

import static org.apache.commons.io.FileUtils.writeByteArrayToFile

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
class Chrome {

    static ChromeDriver get() {
        System.setProperty("webdriver.chrome.driver", driverPath)
        def options = new ChromeOptions()
        def os = System.getProperty('os.name')
        if (!os.contains('Windows')) {
            options.addArguments('headless')
        }
        options.setExperimentalOption('prefs', [
            prompt_for_download     : 0,
            default_content_settings: 0
        ])
        new ChromeDriver(options)
    }

    private static String getDriverPath() {
        def os = System.getProperty('os.name')
        def driverName = os.contains('Windows') ? 'chromedriver.exe' : 'chromedriver'
        def temp = System.getProperty('java.io.tmpdir')

        def driverFile = temp + File.separator + driverName as File
        if (!driverFile.exists()) {
            driverFile.createNewFile()
            def driver = new ClassPathResource(driverName)
            writeByteArrayToFile(driverFile, driver.inputStream.bytes)
        }
        driverFile.absolutePath
    }

}
