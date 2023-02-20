package com.goofy.localcache.service

import com.goofy.localcache.repository.TestRepository
import mu.KotlinLogging
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class TestCacheService(
    private val testRepository: TestRepository
) {
    private val logger = KotlinLogging.logger {}

    @Cacheable(
        cacheManager = "testEhCacheManager",
        cacheNames = ["Test.getTest"],
        key = "#id"
    )
    fun getTest(id: Long): String? {
        return testRepository.findById(id)
    }
}
