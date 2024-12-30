package dev.spring.transactions.config;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Data
@Configuration
@ConfigurationProperties(prefix = "transactions")
public class TransactionConfig {

    private boolean debugModeEnabled;

    @PostConstruct
    public void init() {
        log.info("Transactions Properties : {}", this);
    }

}
