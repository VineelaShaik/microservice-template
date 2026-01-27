package com.company.platform.integration.messaging.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@Configuration
@ConditionalOnProperty(
        name = "rabbitmq.enabled",
        havingValue = "true",
        matchIfMissing = false
)
public class RabbitConfig {

    @Bean
    public Queue sampleQueue() {
        return new Queue("sample.queue", true);
    }
}
