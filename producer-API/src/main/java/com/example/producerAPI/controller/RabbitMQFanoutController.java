package com.example.producerAPI.controller;

import com.example.producerAPI.Enums.RoutingKey;
import com.example.producerAPI.service.RabbitMQFanoutService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fanout")
@Api(value = "Estudos Rabbit Fanout Exchanges.")
public class RabbitMQFanoutController {

    private RabbitMQFanoutService service;

    public RabbitMQFanoutController(RabbitMQFanoutService service){
        this.service = service;
    }

    @PostMapping("/{message}")
    public ResponseEntity sendMessage(@PathVariable("message") String message){
        service.sendToFanoutExchangeMessage(message);
        return ResponseEntity.ok("A seguinte mensagem: "+ message +" foi enviada.");
    }

}
