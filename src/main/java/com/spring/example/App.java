package com.spring.example;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	// @Autowired
	// IProductRepository ProductRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// Product p1 = new Product("Tv_Tubo",50.00,"C:\\Teste","Televisão de tubo de 40 polegadas","17-11-2019");
		// Product p2 = new Product("Smart_Tv",3500.00,"C:\\Teste","Smart televisão 40 polegadas","17-11-2019");
		// Product p3 = new Product("Tv_led",1000.00,"C:\\Teste","Televisão de led de 40 polegadas","17-11-2019");
		// Product p4 = new Product("Tv_plasma",800.00,"C:\\Teste","Televisão de plasma de 40 polegadas","17-11-2019");
		
		// ProductRepository.saveAll(Arrays.asList(p1,p2,p3,p4));

		
	}

}
