package net.dleguis.seedbox.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = { "net.dleguis" })
@EnableWebMvc
public class SeedboxManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeedboxManagerApplication.class, args);
	}
}
