require('dotenv').config();

const kafka = require('kafka-node');
const Consumer = kafka.ConsumerGroup;

const _client = kafka.Consumer;
const _consumer = new Consumer(
  _client, 
  'data-group', 
  {
    groupId: 'data-group',
    autoCommit: true,
    autoCommitIntervalMs: 5000,
    encoding: 'utf8',
    keyEncoding: 'utf8'
  }
);

_consumer.on('message', (message) => {
    console.log(message);
});
