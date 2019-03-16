import uuid

from kafka import KafkaProducer

KAFKA_SERVER_LIST  = 'localhost:9090,localhost:9091,localhost:9092'
KAFKA_TOPIC = 'data-group'

# creates a conection to the broker servers
producer = KafkaProducer(bootstrap_servers=KAFKA_SERVER_LIST)

for _ in range(100_000):
    message = "{0} - PYTHON {1}".format(uuid.uuid1(), _)
    producer.send(KAFKA_TOPIC, bytes(message, encoding='utf8'))

producer.flush()
