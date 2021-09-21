package io.betterbanking;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

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

	@Bean
	public String tokenToGetTransaction(){
		return null;
	}



	public static void main(String[] args) {
		SpringApplication.run(BetterBankingApplication.class, args);
		//System.out.println(baseUrl);
	}
}
