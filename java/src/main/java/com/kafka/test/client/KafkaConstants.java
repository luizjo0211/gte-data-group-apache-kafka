package com.kafka.test.client;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.UUID;

public interface KafkaConstants {
    public static String KAFKA_BROKERS = "localhost:9090,localhost:9091,localhost:9092";
    public static Integer MESSAGE_COUNT = 1000;
    public static String CLIENT_ID = UUID.randomUUID().toString();
    public static String TOPIC_NAME = "data-group";
    public static String GROUP_ID_CONFIG = "data-group";
    public static Integer MAX_NO_MESSAGE_FOUND_COUNT = 100;
    public static String OFFSET_RESET_LATEST = "latest";
    public static String OFFSET_RESET_EARLIER = "earliest";
    public static Integer MAX_POLL_RECORDS = 1000;
}
