package com.see.audit.config

import com.see.core.domain.WithCreationTracker
import groovy.transform.Canonical
import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@Document(collection = "audit")
@Canonical
@Builder(builderStrategy = SimpleStrategy)
class Audit extends WithCreationTracker {

    String title

    String platform

    String type

    String factMaster
    String fact

    String content

}
