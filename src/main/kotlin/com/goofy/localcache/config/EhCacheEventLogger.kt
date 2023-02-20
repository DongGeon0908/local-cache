package com.goofy.localcache.config

import mu.KotlinLogging
import org.ehcache.event.CacheEvent
import org.ehcache.event.CacheEventListener

class EhCacheEventLogger : CacheEventListener<String, Any> {
    private val logger = KotlinLogging.logger {}

    override fun onEvent(cacheEvent: CacheEvent<out String, out Any>) {
        logger.info { "cache event logger key : ${cacheEvent.key} / oldValue : ${cacheEvent.oldValue} / newValue : ${cacheEvent.newValue}" }
    }
}
