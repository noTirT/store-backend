package com.tom.selling;

import com.tom.selling.model.ArtPiece;
import com.tom.selling.repository.ArtRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class SellingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellingApplication.class, args);
	}
}
