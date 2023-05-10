package com.mood.Moodania.Presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;
import kotlin.*;
import privet.Manera;

@SpringBootApplication(scanBasePackages = {"com.mood.Moodania.ServiceLayer", "com.mood.Moodania.Presentation" , "com.mood.Moodania.DataAccessLayer"} )
@EnableJpaRepositories(basePackages={"com.mood.Moodania"})
@EntityScan("com.mood.Moodania")
public class MoodaniaApplication {
	public static void main(String[] args) {

/*
		SpringApplication.run(MoodaniaApplication.class, args);
*/
		Manera manera = new Manera();
		manera.manera(new String[2]);
	}

}
