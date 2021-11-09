package com.example.consumerAPI.config;

import static com.example.consumerAPI.constants.RabbitConstants.CUSTOM_JUNIOR_QUEUE;
import static com.example.consumerAPI.constants.RabbitConstants.CUSTOM_PLENO_QUEUE;
import static com.example.consumerAPI.constants.RabbitConstants.CUSTOM_SENIOR_QUEUE;
import static com.example.consumerAPI.constants.RabbitConstants.CUSTOM_SPEC_QUEUE;
import static com.example.consumerAPI.constants.RabbitConstants.CUSTOM_ALL_QUEUE;
import static com.example.consumerAPI.constants.RabbitConstants.CUSTOM_TOPIC_EXCHANGE;
import static com.example.consumerAPI.constants.RabbitConstants.TOPIC_PREFIX;

import com.example.consumerAPI.Enums.RoutingKey;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {

    @Bean
    Queue customTopicJuniorQueue() {
        return new Queue(CUSTOM_JUNIOR_QUEUE, true);
    }

    @Bean
    Queue customTopicPlenoQueue() {
        return new Queue(CUSTOM_PLENO_QUEUE, true);
    }

    @Bean
    Queue customTopicSeniorQueue() {
        return new Queue(CUSTOM_SENIOR_QUEUE, true);
    }

    @Bean
    Queue customTopicSpecQueue() {
        return new Queue(CUSTOM_SPEC_QUEUE, true);
    }

    @Bean
    Queue allQueue() {
        return new Queue(CUSTOM_ALL_QUEUE, true);
    }

    @Bean
    TopicExchange topicExchange() {return new TopicExchange(CUSTOM_TOPIC_EXCHANGE);}

    @Bean
    Binding customTopicJuniorBinding(Queue customTopicJuniorQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(customTopicJuniorQueue).to(topicExchange).with(RoutingKey.junior + TOPIC_PREFIX);
    }

    @Bean
    Binding customTopicPlenoBinding(Queue customTopicPlenoQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(customTopicPlenoQueue).to(topicExchange).with(RoutingKey.pleno + TOPIC_PREFIX);
    }

    @Bean
    Binding customTopicSeniorBinding(Queue customTopicSeniorQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(customTopicSeniorQueue).to(topicExchange).with(RoutingKey.senior + TOPIC_PREFIX);
    }

    @Bean
    Binding customTopicSpecBinding(Queue customTopicSpecQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(customTopicSpecQueue).to(topicExchange).with(RoutingKey.spec + TOPIC_PREFIX);
    }

    @Bean
    Binding allBinding(Queue allQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(allQueue).to(topicExchange).with( "*" + TOPIC_PREFIX);
    }
}
