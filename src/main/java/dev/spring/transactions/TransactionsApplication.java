package dev.spring.transactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/* ToDO:
*		1. Build and Deploy from inside docker-compose
*		2. Enable Logback outside the application
* 		3. refresh app config in run time
* 		4. prometheus & grafana setUp
*
* */

@EnableCaching
@SpringBootApplication
public class TransactionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionsApplication.class, args);
	}

}
