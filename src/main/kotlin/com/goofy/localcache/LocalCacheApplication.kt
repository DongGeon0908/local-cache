package com.goofy.localcache

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LocalCacheApplication

fun main(args: Array<String>) {
    runApplication<LocalCacheApplication>(*args)
}
