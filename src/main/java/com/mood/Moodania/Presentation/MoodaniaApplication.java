package com.mood.Moodania.Presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.mood.Moodania.ServiceLayer", "com.mood.Moodania.Presentation" , "com.mood.Moodania.DataAccessLayer"} )
public class MoodaniaApplication {
	public static void main(String[] args) {
		SpringApplication.run(MoodaniaApplication.class, args);
	}

}
