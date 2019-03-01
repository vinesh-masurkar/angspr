package com.vim.angspr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AngsprApplication {

	//@Autowired
	//UserRepository userRepository;

	// SSH:   git@github.com:masurkarvinesh/angspr.git
	// HTTPS: https://github.com/masurkarvinesh/angspr.git
	public static void main(String[] args) {
		SpringApplication.run(AngsprApplication.class, args);
	}
}
