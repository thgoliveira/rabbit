package com.example.producerAPI.service;

import static com.example.producerAPI.constants.RabbitConstants.CUSTOM_FANOUT_EXCHANGE;

import com.example.producerAPI.Enums.RoutingKey;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQFanoutService {

    private RabbitTemplate rabbitTemplate;

    public RabbitMQFanoutService(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendToFanoutExchangeMessage(String message) {
        System.out.println("Starting......");
        rabbitTemplate.convertAndSend(CUSTOM_FANOUT_EXCHANGE, "", message);
        System.out.println("Sended to " + CUSTOM_FANOUT_EXCHANGE + " " + message);
        System.out.println("Send success!");
    }
}
