package com.example.fakerclient2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FakerClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(FakerClient2Application.class, args);
	}

//	@Bean
//	CommandLineRunner lookup(UsersClient quoteClient) {
//		return args -> {
//
//			Long user = 11L;
//
//			GetUserByIdResponse response = quoteClient.getUsersById(user);
//			System.err.println(response.getUsers().getName());
//			GetUsersResponse response1 = quoteClient.getUsers();
//			System.out.println(response1.getUsers());
//		};
//	}
}
