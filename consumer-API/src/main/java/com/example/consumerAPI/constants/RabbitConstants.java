package com.example.consumerAPI.constants;

public class RabbitConstants {
    public static final String TOPIC_PREFIX = ".queue";
    public static final String HEADER_PREFIX = "nivel";

    public static final String CUSTOM_DIRECT_EXCHANGE = "custom_direct_exchange";
    public static final String CUSTOM_FANOUT_EXCHANGE =  "custom_fanout_exchange";
    public static final String CUSTOM_TOPIC_EXCHANGE = "custom_topic_exchange";
    public static final String CUSTOM_HEADER_EXCHANGE = "custom_header_exchange";

    public static final String CUSTOM_JUNIOR_QUEUE = "custom_junior_queue";
    public static final String CUSTOM_PLENO_QUEUE =  "custom_pleno_queue";
    public static final String CUSTOM_SENIOR_QUEUE = "custom_senior_queue";
    public static final String CUSTOM_SPEC_QUEUE = "custom_spec_queue";
    public static final String CUSTOM_ALL_QUEUE = "custom_all_queue";
}
