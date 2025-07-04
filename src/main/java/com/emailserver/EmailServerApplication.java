package com.emailserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class EmailServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailServerApplication.class, args);
//		EmailRequest request = new EmailRequest();
//		request.setFrom("tamer.saliba36@walla.com");
//		request.setTo("svetlana_melamed@bmc.com");
//		request.setBody("Test Email");
//		EmailService service = new EmailService();
//		service.sendEmail(request);

	}

}
