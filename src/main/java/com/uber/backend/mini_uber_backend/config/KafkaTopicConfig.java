package com.uber.backend.mini_uber_backend.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic tripRequestsTopic() {
        return new NewTopic("trip-requests", 1, (short) 1);
    }
}
