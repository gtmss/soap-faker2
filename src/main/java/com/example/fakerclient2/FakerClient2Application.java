package com.example.fakerclient2;

import com.example.fakerclient2.client.UsersClient;
import com.example.fakerclient2.wsdl.GetUserByIdResponse;
import com.example.fakerclient2.wsdl.GetUsersResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
