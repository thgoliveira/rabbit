package com.example.producerAPI.controller;

import com.example.producerAPI.Enums.RoutingKey;
import com.example.producerAPI.service.RabbitMQDirectService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/direct")
@Api(value = "Estudos Rabbit Direct Exchanges.")
public class RabbitMQDirectController {

    private RabbitMQDirectService service;

    public RabbitMQDirectController(RabbitMQDirectService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getAny() {
        return  ResponseEntity.ok("Deu get.");
    }

    @PostMapping("/{message}")
    public ResponseEntity sendMessage(RoutingKey routingKey, @PathVariable("message") String message){
        service.sendToDirectExchangeMessage(routingKey, message);
        return ResponseEntity.ok("A seguinte mensagem: "+ message +" foi enviada.");
    }
}
