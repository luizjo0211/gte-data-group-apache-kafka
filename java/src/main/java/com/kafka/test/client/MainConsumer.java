package com.kafka.test.client;


import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class MainConsumer {
    public static void main(String... args) {
        run();
    }

    public static void run() {
        Consumer<String, String> consumer = ConsumerBuilder.build();
        int counter = 0;

        while (true) {
            // time in milliseconds the consumer will wait if there are no records
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(30));

            records.forEach(record -> {
                System.out.println("Key: " + record.key());
                System.out.println("Value: " + record.value());
                System.out.println("Partitiom: " + record.partition());
                System.out.println("Offset: " + record.offset());
                System.out.println();
            });
        }
    }
}
