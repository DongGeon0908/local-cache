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
    companion object {
        private const val EHCACHE_XML_PATH = "ehcache.xml"
    }

    @Bean
    fun cacheManagerFactoryBean(): JCacheManagerFactoryBean {
        return JCacheManagerFactoryBean().apply {
            val path = ClassPathResource(EHCACHE_XML_PATH).uri
            this.setCacheManagerUri(path)
        }
    }

    @Bean
    fun testEhCacheManager(): CacheManager {
        return JCacheCacheManager().apply {
            val cacheManager = cacheManagerFactoryBean().getObject()
            this.cacheManager = cacheManager
        }
    }
}
