package com.example.producerAPI.service;

import com.example.producerAPI.Enums.RoutingKey;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.example.producerAPI.constants.RabbitConstants.CUSTOM_DIRECT_EXCHANGE;

import java.util.Objects;

@Service
public class RabbitMQDirectService {

    private RabbitTemplate rabbitTemplate;

    public RabbitMQDirectService(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendToDirectExchangeMessage(RoutingKey routingKey, String message){
        System.out.println("Starting......");
        try{
            rabbitTemplate.convertAndSend(CUSTOM_DIRECT_EXCHANGE, routingKey.toString(), message);
        System.out.println("Sended to " + CUSTOM_DIRECT_EXCHANGE + " " + message);
        } catch (NullPointerException e) {
            System.out.println("Routing key cannot be null!");
        }
        System.out.println("Send success!");
    }
}
