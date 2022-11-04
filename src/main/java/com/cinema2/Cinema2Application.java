package com.cinema2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cinema2.service.IcinemaInitService;

@SpringBootApplication
public class Cinema2Application implements CommandLineRunner {
	@Autowired
	private IcinemaInitService cinemaInitServices;
	
	public static void main(String[] args) {
		SpringApplication.run(Cinema2Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
			cinemaInitServices.initVilles();
			cinemaInitServices.initCinema();
			cinemaInitServices.initSalles();
			cinemaInitServices.initPlaces();
			cinemaInitServices.initSeances();
			cinemaInitServices.initCategories();
			cinemaInitServices.initFilms();
			cinemaInitServices.initTickeys();
	}

}
