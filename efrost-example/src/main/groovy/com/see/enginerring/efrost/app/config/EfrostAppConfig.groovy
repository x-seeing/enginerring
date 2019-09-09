package com.see.enginerring.efrost.app.config

import com.see.enginerring.baicm.app.config.BaicmAppConf
import com.see.enginerring.chrome.example.app.config.ChromeExampleAppConf
import com.see.enginerring.thruster.app.config.ThrusterAppConf
import com.see.misc.common.CommonWebConf
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Configuration
@EnableAutoConfiguration
@Import([BaicmAppConf, ChromeExampleAppConf, CommonWebConf, ThrusterAppConf])
@ComponentScan('com.see.enginerring.efrost.web')
class EfrostAppConfig {

}
