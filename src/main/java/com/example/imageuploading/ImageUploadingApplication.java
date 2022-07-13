package com.example.imageuploading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableCaching
@EnableScheduling
public class ImageUploadingApplication {

  private static final Logger Log = LoggerFactory.getLogger(ImageUploadingApplication.class);

	public static void main(String[] args) {

		  ConfigurableApplicationContext applicationContext = SpringApplication.run(ImageUploadingApplication.class, args);

		  Object bean = applicationContext.getBean("myProp");

		  String myProp = (String) bean ;
		  System.out.println(myProp);

		  Log.info("User Welcome to Rest");


	}

}
