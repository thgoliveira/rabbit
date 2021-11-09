package com.example.consumerAPI.Enums;

import org.springframework.lang.Nullable;

public enum RoutingKey {

    junior("junior"),
    pleno("pleno"),
    senior("senior"),
    spec("spec");

    @Nullable
    private String routingKey;

    RoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getRoutingKey() {
        return routingKey;
    }
}
