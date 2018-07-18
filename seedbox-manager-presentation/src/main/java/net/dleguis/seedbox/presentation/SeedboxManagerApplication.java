package net.dleguis.seedbox.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * The type Seedbox manager application.
 */
@SpringBootApplication(scanBasePackages = { "net.dleguis.seedbox.presentation", "net.dleguis.seedbox.service", "net.dleguis.seedbox.domain" })
@EnableWebMvc
public class SeedboxManagerApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args
	 *            the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SeedboxManagerApplication.class, args); // NOSONAR
	}
}
