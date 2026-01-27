package com.company.platform.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(
    name = "spring.datasource.url"
)
public class DatabaseConfig {
}
