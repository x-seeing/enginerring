package com.see.enginerring.thruster.patrol

import com.see.enginerring.thruster.domain.Capture
import com.see.enginerring.thruster.domain.Thruster
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component

import static com.see.core.http.Http.getProxyC
import static com.see.core.retry.Retry.withRetry
import static groovyx.net.http.ContentType.TEXT

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Slf4j
@Component
class ShekendPatrol extends PatrolSupport implements Patrol, Captor {

    public static final String PLATFORM = "shekend"
    public static final String SERVICE_HOST = "shekend_host"

    @Override
    List<Thruster> patrol() {
        def thrusters = (0..5).inject([]) { prev, it ->
            def pageResults = doPatrol(it)
            if (pageResults) {
                prev.addAll(pageResults - null)
            }
            prev
        }
        log.debug("shekend patrol finished: {}", thrusters)
        thrusters
    }

    static def doPatrol(int idx) {
        withRetry(3, 0) {
            getProxyC("${SERVICE_HOST}/index.php").get([
                contentType: TEXT,
                query      : [p: idx + 1]
            ]) { resp, html ->
                def h = saxParser.parse(html)
                h.depthFirst().DIV.find { it.@id == 'content' }?.TABLE?.TBODY?.TR?.collect {
                    if (it.breadthFirst().DIV.find { 'ad_row' == it.@id }) {
                        return null
                    }
                    def td = it.TD
                    new Thruster([
                        platform: PLATFORM,
                        code    : td[0].text(),
                        p       : td[1].text(),
                        country : td[2].IMG.@alt
                    ])
                }
            }
        }
    }

    @Override
    List<Capture> capture(String key, String p) {
        withRetry(3, 0) {
            getProxyC("${SERVICE_HOST}/detail.php").get([
                contentType: TEXT,
                query      : [id: p]
            ]) { resp, html ->
                def h = saxParser.parse(html)
                def firstPage = h.depthFirst().DIV.find { it.@id == 'content' }?.TABLE?.TBODY?.TR
                def c = firstPage?.findResult {
                    def td = it.TD
                    String content = td[2].text()
                    if (key && content.contains(key)) {
                        buildCapture(key, p, content)
                    }
                }
                if (c) {
                    return [c]
                } else {
                    return firstPage.findResults {
                        def td = it.TD
                        String content = td[2].text()
                        buildCapture(key, p, content)
                    }
                }
            }
        }
    }

    @Override
    Boolean capableOf(String platform) {
        PLATFORM
    }

}
