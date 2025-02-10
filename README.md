# kafka-fundamentals


### Managing Schemas

A schema defines the structure of message data. It defines allowed data types, their format, and relationships. A schema acts as a blueprint for data, describing the structure of data records, the data types of individual fields, the relationships between fields, and any constraints or rules that apply to the data.

Schemas are used in various data processing systems, including databases, message brokers, and distributed event and data processing frameworks. They help ensure that data is consistent, accurate, and can be efficiently processed and analyzed by different systems and applications.


```shell script
#List all subjects
curl -X GET http://localhost:8081/subjects

# Register a new version under subject users-value
curl -X POST -H "Content-Type: application/json" --data '{"schema": "{\"type\": \"string\"}"}' http://localhost:8081/subjects/users-value/versions
    
```


### References
https://docs.confluent.io/platform/current/schema-registry/index.html
