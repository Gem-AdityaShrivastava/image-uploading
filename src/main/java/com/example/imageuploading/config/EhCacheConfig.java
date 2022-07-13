package com.example.imageuploading.config;


import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class EhCacheConfig {

//    CacheManager cacheManager(){
//        return new EhCacheCacheManager(ehCacheManger());
//    }
//
//    private net.sf.ehcache.CacheManager ehCacheManger(){
//
//        EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
//
//        factoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
//        factoryBean.setShared(true);
//
//        return factoryBean.getObject();
//    }
}
