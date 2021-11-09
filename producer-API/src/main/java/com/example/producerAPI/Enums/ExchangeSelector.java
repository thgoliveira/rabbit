package com.example.producerAPI.Enums;

import static com.example.producerAPI.constants.RabbitConstants.CUSTOM_DIRECT_EXCHANGE;
import static com.example.producerAPI.constants.RabbitConstants.CUSTOM_FANOUT_EXCHANGE;
import static com.example.producerAPI.constants.RabbitConstants.CUSTOM_TOPIC_EXCHANGE;
import static com.example.producerAPI.constants.RabbitConstants.CUSTOM_HEADER_EXCHANGE;

import org.springframework.lang.Nullable;

public enum ExchangeSelector {

    DIRECT(CUSTOM_DIRECT_EXCHANGE),
    FANOUT(CUSTOM_FANOUT_EXCHANGE),
    TOPIC(CUSTOM_TOPIC_EXCHANGE),
    HEADER(CUSTOM_HEADER_EXCHANGE);

    @Nullable
    private String exchange;

    ExchangeSelector(String exchange){ this.exchange = exchange;}

    @Nullable
    public String getExchange() {
        return exchange;
    }
}
