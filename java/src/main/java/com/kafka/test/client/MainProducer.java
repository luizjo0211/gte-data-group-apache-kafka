package com.kafka.test.client;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class MainProducer {
    public static void main(String... args) {
        Runnable runner = () -> run();

        new Thread(runner).start();
        new Thread(runner).start();
        new Thread(runner).start();
    }

    public static void run() {
        Producer<String, String> producer = ProducerBuilder.build();

        for (int index = 0; index < 100_000; index++) {
            String message = String.format("%s - JAVA %d", UUID.randomUUID(), index);
            ProducerRecord<String, String> record = new ProducerRecord<>(KafkaConstants.TOPIC_NAME, message);

            producer.send(record);
        }
    }
}
