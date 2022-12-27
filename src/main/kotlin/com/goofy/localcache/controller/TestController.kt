package com.goofy.localcache.controller

import com.goofy.localcache.service.TestService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/test/v1")
class TestController(
    private val testService: TestService
) {
    @GetMapping("/{id}")
    fun get(@PathVariable id: Long) = testService.getData(id)
}
