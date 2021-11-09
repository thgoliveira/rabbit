package com.example.consumerAPI.config;

import static com.example.consumerAPI.constants.RabbitConstants.CUSTOM_FANOUT_EXCHANGE;
import static com.example.consumerAPI.constants.RabbitConstants.CUSTOM_JUNIOR_QUEUE;
import static com.example.consumerAPI.constants.RabbitConstants.CUSTOM_PLENO_QUEUE;
import static com.example.consumerAPI.constants.RabbitConstants.CUSTOM_SENIOR_QUEUE;
import static com.example.consumerAPI.constants.RabbitConstants.CUSTOM_SPEC_QUEUE;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQFanoutConfig {

    @Bean
    Queue customFanoutJuniorQueue() {
        return new Queue(CUSTOM_JUNIOR_QUEUE, true);
    }

    @Bean
    Queue customFanoutPlenoQueue() {
        return new Queue(CUSTOM_PLENO_QUEUE, true);
    }

    @Bean
    Queue customFanoutSeniorQueue() {
        return new Queue(CUSTOM_SENIOR_QUEUE, true);
    }

    @Bean
    Queue customFanoutSpecQueue() {
        return new Queue(CUSTOM_SPEC_QUEUE, true);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(CUSTOM_FANOUT_EXCHANGE);
    }

    @Bean
    Binding customFanoutJuniorBinding(Queue customFanoutJuniorQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(customFanoutJuniorQueue).to(fanoutExchange);
    }

    @Bean
    Binding customFanoutPlenoBinding(Queue customFanoutPlenoQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(customFanoutPlenoQueue).to(fanoutExchange);
    }

    @Bean
    Binding customFanoutSeniorBinding(Queue customFanoutSeniorQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(customFanoutSeniorQueue).to(fanoutExchange);
    }

    @Bean
    Binding customFanoutSpecBinding(Queue customFanoutSpecQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(customFanoutSpecQueue).to(fanoutExchange);
    }
}
