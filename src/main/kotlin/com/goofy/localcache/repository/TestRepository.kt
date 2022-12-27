package com.goofy.localcache.repository

import mu.KotlinLogging
import org.springframework.stereotype.Repository
import javax.annotation.PostConstruct

@Repository
class TestRepository {
    private val logger = KotlinLogging.logger {}
    private val DEFAULT_DATA = mutableMapOf<Long, String>()

    @PostConstruct
    fun init() {
        (0L..3000000L).forEach {
            DEFAULT_DATA[it] = "hello$it"
        }

        logger.info { "init test data" }
    }

    fun findById(id: Long): String? {
        return DEFAULT_DATA[id]
    }
}
