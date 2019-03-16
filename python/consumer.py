import uuid
from kafka import KafkaConsumer

consumer = KafkaConsumer('data-group', group_id='data-group', client_id=uuid.uuid1())

try:
    for message in consumer:
        print(message)
        print()
except KeyboardInterrupt:
    print('Program closed')
