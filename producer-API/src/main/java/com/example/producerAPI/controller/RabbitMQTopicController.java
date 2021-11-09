package com.example.producerAPI.controller;

import com.example.producerAPI.constants.RabbitConstants;
import io.swagger.annotations.Api;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.producerAPI.constants.RabbitConstants.CUSTOM_TOPIC_EXCHANGE;

@RestController
@RequestMapping("/topic")
@Api(value = "Estudos Rabbit Topic Exchanges.")
public class RabbitMQTopicController {

    private final AmqpTemplate amqpTemplate;

    public RabbitMQTopicController(AmqpTemplate amqpTemplate){ this.amqpTemplate = amqpTemplate;}

    @GetMapping()
    public ResponseEntity producer(@RequestParam("routingKey") String routingKey,
                                   @RequestParam("messageData") String messageData) {

        amqpTemplate.convertAndSend(CUSTOM_TOPIC_EXCHANGE, routingKey, messageData);

        return ResponseEntity.ok("A seguinte mensagem: "+ messageData +" foi enviada.");
    }

}
