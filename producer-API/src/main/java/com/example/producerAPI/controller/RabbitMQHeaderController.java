package com.example.producerAPI.controller;

import com.example.producerAPI.Enums.RoutingKey;
import com.example.producerAPI.constants.RabbitConstants;
import io.swagger.annotations.Api;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.producerAPI.constants.RabbitConstants.CUSTOM_HEADER_EXCHANGE;
import static com.example.producerAPI.constants.RabbitConstants.HEADER_PREFIX;

@RestController
@RequestMapping("/header")
@Api(value = "Estudos Rabbit Header Exchanges.")
public class RabbitMQHeaderController {

    private final AmqpTemplate amqpTemplate;

    public RabbitMQHeaderController(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @GetMapping()
    public ResponseEntity producer(RoutingKey routingKey,
                                   @RequestParam("messageData") String messageData) {

        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader(HEADER_PREFIX, routingKey);
        MessageConverter messageConverter = new SimpleMessageConverter();
        Message message = messageConverter.toMessage(messageData, messageProperties);
        amqpTemplate.send(CUSTOM_HEADER_EXCHANGE, "", message);

        return ResponseEntity.ok("A seguinte mensagem: "+ message +" foi enviada.");
    }
}
