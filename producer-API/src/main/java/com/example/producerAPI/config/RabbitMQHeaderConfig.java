package com.example.producerAPI.config;

import static com.example.producerAPI.constants.RabbitConstants.CUSTOM_HEADER_EXCHANGE;
import static com.example.producerAPI.constants.RabbitConstants.CUSTOM_JUNIOR_QUEUE;
import static com.example.producerAPI.constants.RabbitConstants.CUSTOM_PLENO_QUEUE;
import static com.example.producerAPI.constants.RabbitConstants.CUSTOM_SENIOR_QUEUE;
import static com.example.producerAPI.constants.RabbitConstants.CUSTOM_SPEC_QUEUE;
import static com.example.producerAPI.constants.RabbitConstants.HEADER_PREFIX;

import com.example.producerAPI.Enums.RoutingKey;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQHeaderConfig {

    @Bean
    Queue customHeaderJuniorQueue() {
        return new Queue(CUSTOM_JUNIOR_QUEUE, true);
    }

    @Bean
    Queue customHeaderPlenoQueue() {
        return new Queue(CUSTOM_PLENO_QUEUE, true);
    }

    @Bean
    Queue customHeaderSeniorQueue() {
        return new Queue(CUSTOM_SENIOR_QUEUE, true);
    }

    @Bean
    Queue customHeaderSpecQueue() {
        return new Queue(CUSTOM_SPEC_QUEUE, true);
    }

    @Bean
    HeadersExchange headerExchange() { return new HeadersExchange(CUSTOM_HEADER_EXCHANGE);}

    @Bean
    Binding customHeaderJuniorBinding(Queue customHeaderJuniorQueue, HeadersExchange headerExchange) {
        return BindingBuilder.bind(customHeaderJuniorQueue).to(headerExchange).where(HEADER_PREFIX).matches("junior");
    }

    @Bean
    Binding customHeaderPlenoBinding(Queue customHeaderPlenoQueue, HeadersExchange headerExchange) {
        return BindingBuilder.bind(customHeaderPlenoQueue).to(headerExchange).where(HEADER_PREFIX).matches("pleno");
    }

    @Bean
    Binding customHeaderSeniorBinding(Queue customHeaderSeniorQueue, HeadersExchange headerExchange) {
        return BindingBuilder.bind(customHeaderSeniorQueue).to(headerExchange).where(HEADER_PREFIX).matches("senior");
    }

    @Bean
    Binding customHeaderSpecBinding(Queue customHeaderSpecQueue, HeadersExchange headerExchange) {
        return BindingBuilder.bind(customHeaderSpecQueue).to(headerExchange).where(HEADER_PREFIX).matches("spec");
    }
}
