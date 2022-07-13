//package com.example.imageuploading.config;
//
//
//import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//@Component
//@Cacheable
//public class CacheConfiguration {
//
//
//    @Bean
//    CacheManagerCustomizer<ConcurrentMapCacheManager> cutomizer(){
//        return new ConcurrentCustomizer();
//    }
//
//    class ConcurrentCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager>{
//
//        @Override
//        public void customize(ConcurrentMapCacheManager cacheManager){
//            cacheManager.setAllowNullValues(false);
//            System.out.println("Customizer Successful");
//        }
//    }
//}
