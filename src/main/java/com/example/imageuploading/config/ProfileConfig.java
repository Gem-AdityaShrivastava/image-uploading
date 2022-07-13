package com.example.imageuploading.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class ProfileConfig {


    @Value("${my.prop}")
    private String myProp;

    @Profile(value={"default"})
    @Bean(name="myProp")
    public String createBeanForDefault(){
        return myProp;
    }

    @Profile(value={"dev"})
    @Bean(name="myProp")
    public String createBeanForDev(){
        return myProp;
    }

}
