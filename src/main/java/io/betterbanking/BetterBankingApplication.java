package io.betterbanking;

import io.betterbanking.entity.Transaction;
import io.betterbanking.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
)
public class BetterBankingApplication {
	@Value("${testnet.main.base-url}")
	private String baseUrl;

	@Bean
	public WebClient createInstanceOfWebClient(){
		WebClient webClient = WebClient
				.builder()
				.baseUrl(baseUrl)
				.build();
		return webClient;
	}


	@Profile("dev")
	@Bean
	public ApplicationRunner dataLoader(TransactionRepository repo) {
		return args -> {
			repo.deleteAll();
			repo.save(new Transaction(1,"Credit", new Date(),12345,"USD",55.00,"ABC","abc-logo.png"));
			repo.save(new Transaction(2,"Dedit", new Date(),12345,"USD",100.00,"ABC","abc-logo.png"));
			repo.save(new Transaction(3,"Dedit", new Date(),12345,"USD",350.00,"ABC","abc-logo.png"));
		};
	}


	public static void main(String[] args) {
		SpringApplication.run(BetterBankingApplication.class, args);
		//System.out.println(baseUrl);
	}
}
