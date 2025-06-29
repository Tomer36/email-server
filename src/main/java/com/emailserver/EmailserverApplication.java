package com.emailserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EmailserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailserverApplication.class, args);
//		EmailRequest request = new EmailRequest();
//		request.setFrom("tamer.saliba36@walla.com");
//		request.setTo("svetlana_melamed@bmc.com");
//		request.setBody("Test Email");
//		EmailService service = new EmailService();
//		service.sendEmail(request);

	}

}
