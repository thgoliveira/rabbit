package com.example.consumerAPI.config;

import static com.example.consumerAPI.constants.RabbitConstants.CUSTOM_DIRECT_EXCHANGE;
import static com.example.consumerAPI.constants.RabbitConstants.CUSTOM_JUNIOR_QUEUE;
import static com.example.consumerAPI.constants.RabbitConstants.CUSTOM_PLENO_QUEUE;
import static com.example.consumerAPI.constants.RabbitConstants.CUSTOM_SENIOR_QUEUE;
import static com.example.consumerAPI.constants.RabbitConstants.CUSTOM_SPEC_QUEUE;

import com.example.consumerAPI.Enums.RoutingKey;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDirectConfig {
    @Bean
    Queue customDirectJuniorQueue() {
        return new Queue(CUSTOM_JUNIOR_QUEUE, true);
    }

    @Bean
    Queue customDirectPlenoQueue() {
        return new Queue(CUSTOM_PLENO_QUEUE, true);
    }

    @Bean
    Queue customDirectSeniorQueue() {
        return new Queue(CUSTOM_SENIOR_QUEUE, true);
    }

    @Bean
    Queue customDirectSpecQueue() {
        return new Queue(CUSTOM_SPEC_QUEUE, true);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(CUSTOM_DIRECT_EXCHANGE);
    }

    @Bean
    Binding customDirectJuniorBinding(Queue customDirectJuniorQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(customDirectJuniorQueue)
                .to(directExchange)
                .with(RoutingKey.junior);
    }

    @Bean
    Binding customDirectPlenoBinding(Queue customDirectPlenoQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(customDirectPlenoQueue)
                .to(directExchange)
                .with(RoutingKey.pleno);
    }

    @Bean
    Binding customDirectSeniorBinding(Queue customDirectSeniorQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(customDirectSeniorQueue)
                .to(directExchange)
                .with(RoutingKey.senior);
    }

    @Bean
    Binding customDirectSpecBinding(Queue customDirectSpecQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(customDirectSpecQueue)
                .to(directExchange)
                .with(RoutingKey.spec);
    }

}
