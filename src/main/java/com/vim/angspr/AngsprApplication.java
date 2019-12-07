package com.vim.angspr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AngsprApplication {

	//@Autowired
	//UserRepository userRepository;
  // git reset --hard

	// SSH:   git@github.com:masurkarvinesh/angspr.git 		>> 1J
	// HTTPS: https://github.com/masurkarvinesh/angspr.git	>> 1J*
	public static void main(String[] args) {
		SpringApplication.run(AngsprApplication.class, args);
	}
}
