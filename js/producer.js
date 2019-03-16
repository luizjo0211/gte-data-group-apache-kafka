require('dotenv').config();

const uuid = require('uuid/v1')
const kafka = require('kafka-node');
const Producer = kafka.Producer;

const _client = new kafka.KafkaClient();

// send information to te kafka server when
// the application is ready
const _producer = new Producer(_client);

function getMessages() {
    const execution = uuid();
    
    const result = Array(10000).fill(0).map((_, position) => ({
        topic: process.env.TOPIC_NAME,
        messages: `${execution} - JS ${position}`
    }));

    return result;
}

_producer.on('ready', () => {
    const messages = getMessages();

    _producer.send(messages, (error, data) => {
        if(error) {
            console.log(
                'Error sending messages to the brokers: ERROR: ',
                error,
            );
            process.exit(1);
        } else {
            console.log(data);
            process.exit(0);
        }
    });
});

_producer.on('error', (error) => 
    console.log('General error: Error: ', error));
