package com.goofy.localcache.config

import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.jcache.JCacheCacheManager
import org.springframework.cache.jcache.JCacheManagerFactoryBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource


@Configuration
@EnableCaching
class EhCacheConfiguration {
    @Bean
    fun cacheManagerFactoryBean(): JCacheManagerFactoryBean {
        return JCacheManagerFactoryBean().apply {
            this.setCacheManagerUri(ClassPathResource("ehcache.xml").uri)
        }
    }

    @Bean
    fun testEhCacheManager(): CacheManager {
        return JCacheCacheManager().apply {
            this.cacheManager = cacheManagerFactoryBean().getObject()
        }
    }
}
