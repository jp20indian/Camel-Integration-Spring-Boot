# Camel-Integration-Spring-Boot
This project implements some basic functionalities of camel integration between 2 microservices.

## Keywords

 - from()
 - to()
 - log()
 - process()
 - transform()
 - unmarshal()
 - Active Mq
 - docker
 - timer
 - file


## Documentation

- An Active Mq instance is launched as a docker container where messages will be queued.
- Microservice A sends messages/files to the Active Mq using Camel Integration to Active Mq endpoint.
- The queued data is then fetched by Microservice B from Active Mq endpoint for further processing, transformation and transmission to another endpoint that might be a database or file-server.
- Inside Microservice B, Json data that is fetched, is unmarshalled (extracted), transfomed to JAVA object and then sent to different endpoints for further processing.

## EIP Patterns

#### Pipeline

```http
  It executes each instructuion sequentially
```

#### Multicast

```http
  It refers to transmitting the data to mutiple endpoints.
``` 

#### Splitter

```http
  It lets us to split the message body according to conditions and delimiters and then transmsit it.
  Eg : Csv files body can be divided into seperate lines and each line can be divided into seperate data based on "," (comma) delimiter.
``` 

#### Content-Based Routing

```http
 We can check the type of message body and transmsit it accordingly.
``` 

#### Aggregation

```http
 We can group sub-data of message body on the basis of certain conditions and transmsit it to its appropriate endpoint.
``` 

#### Routing Slip

```http
 It lets us to dynamically decide which endpoint to route the data to. A custom logic is written to achieve this.
``` 

#### Dynamic Routing

```http
 After each step of message processing, we decide which endpoint to route the current message state to and route it accordingly.
``` 
