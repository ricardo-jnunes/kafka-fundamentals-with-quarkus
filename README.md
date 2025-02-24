# kafka-fundamentals

- Quarkus Framework
- REST APIs
- Kafka
	- Creating Topics
	- Using Confluent Schema Registry
	- Receive message payload directly with @Incoming
	- Receive message payload with @Channel where the application code is responsible for the subscription
	- A Consumer and a Producer application
- Docker Compose

- TODO
   - Kafka Streams
   - Reinforce the use of Schema Registry
   - Handle errors
   - Unit Tests and TopologyTestDriver
## Initing

### Configure your hosts
```code
127.0.0.1 kafka
127.0.0.1 zookeeper
127.0.0.1 schema-registry
127.0.0.1 connect
127.0.0.1 ksqldb-server
127.0.0.1 postgres
```
Go to `images` directory and check for the README file.

### Creating the Topics

Check the README.md file, specifically the Kafka section in the `app/java/quarkus/producer` directory.

### Using and validating

When you start the Producer Quarkus APp and the Consumer Quarkus App, you will see the `hello message` being produced and consumed automatically.

To see a message being produced and consumed with a contract managed by the Confluent Schema Registry.

```shell script
#Send a message through REST API
curl -X POST http://localhost:8084/user

#Get message through REST API
curl -N http://localhost:8082/consumed-users
```

## Managing Schemas

A schema defines the structure of message data. It defines allowed data types, their format, and relationships. A schema acts as a blueprint for data, describing the structure of data records, the data types of individual fields, the relationships between fields, and any constraints or rules that apply to the data.

Schemas are used in various data processing systems, including databases, message brokers, and distributed event and data processing frameworks. They help ensure that data is consistent, accurate, and can be efficiently processed and analyzed by different systems and applications.

If you use Confluent Schema Registry, you don’t have to configure `value.deserializer/serializer` or `specific.avro.reader` either. They are both detected automatically.


```shell script
#List all subjects and confirm that you have the response ["userinfo-value"]
curl -X GET http://localhost:8081/subjects

# Register a new version under subject users-value
curl -X POST -H "Content-Type: application/json" --data '{"schema": "{\"type\": \"string\"}"}' http://localhost:8081/subjects/users-value/versions
    
```


### References
https://docs.confluent.io/platform/current/schema-registry/index.html
