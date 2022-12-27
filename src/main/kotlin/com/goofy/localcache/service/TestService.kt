package com.goofy.localcache.service

import org.springframework.stereotype.Service

@Service
class TestService(
    private val testCacheService: TestCacheService
) {
    fun getData(id: Long): String {
        return testCacheService.getTest(id) ?: "데이터 없음"
    }
}
