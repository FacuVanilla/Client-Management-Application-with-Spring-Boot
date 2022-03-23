package com.oluwaseun.clientmanagement;

import com.oluwaseun.clientmanagement.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientManagementApplication.class, args);
	}

	@Autowired
	private ClientRepository clientRepository;
}
