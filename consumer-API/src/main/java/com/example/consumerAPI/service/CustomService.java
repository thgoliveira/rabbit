package com.example.consumerAPI.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.example.consumerAPI.constants.RabbitConstants.CUSTOM_JUNIOR_QUEUE;
import static com.example.consumerAPI.constants.RabbitConstants.CUSTOM_PLENO_QUEUE;
import static com.example.consumerAPI.constants.RabbitConstants.CUSTOM_SENIOR_QUEUE;
import static com.example.consumerAPI.constants.RabbitConstants.CUSTOM_SPEC_QUEUE;
import static com.example.consumerAPI.constants.RabbitConstants.CUSTOM_ALL_QUEUE;

@Component
public class CustomService {

    @RabbitListener(queues = CUSTOM_JUNIOR_QUEUE)
    public void customDirectConsumer(Message message){
        System.out.println(message);
        System.out.println("Mensagem da queue " + CUSTOM_JUNIOR_QUEUE + " consumida com sucesso!");
    }

    @RabbitListener(queues = CUSTOM_PLENO_QUEUE)
    public void customFanoutConsumer(Message message){
        System.out.println(message);
        System.out.println("Mensagem da queue " + CUSTOM_PLENO_QUEUE + " consumida com sucesso!");
    }

    @RabbitListener(queues = CUSTOM_SENIOR_QUEUE)
    public void customTopicConsumer(Message message){
        System.out.println(message);
        System.out.println("Mensagem da queue " + CUSTOM_SENIOR_QUEUE + " consumida com sucesso!");
    }

    @RabbitListener(queues = CUSTOM_SPEC_QUEUE)
    public void customHeaderConsumer(Message message){
        System.out.println(message);
        System.out.println("Mensagem da queue " + CUSTOM_SPEC_QUEUE + " consumida com sucesso!");
    }

    @RabbitListener(queues = CUSTOM_ALL_QUEUE)
    public void customAllConsumer(Message message){
        System.out.println(message);
        System.out.println("Mensagem da queue " + CUSTOM_ALL_QUEUE + " consumida com sucesso!");
    }
}
