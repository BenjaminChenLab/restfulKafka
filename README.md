# restfulKafka

To send and retrieve message to/from Kafka via restful APIs.

!important: This project is only a exercise.

##How to start servers
1. change directory to where the pom.xml exists.
2. execute 'mvn package docker:build' 
3. use 'docker images' to check if new image: lab-benjamin/restful-kafka generated locally.
4. edit docker-compose.yml: to modify AFKA_ADVERTISED_HOST_NAME and RESTFULKAFKA_KAFKA_HOST_NAME as your machine host name.
5. execute 'docker-compose up', the three applications will be launched automatically.

##Restful APIs
###produce
---to be done 
###consume
---to be done 

##Note
Because my personnal time was too limited, therefore, the rearch on Kafka has not been completed. The logics and the Kafka api usage are might be incorrect .
I have not test restful APIs yet, but the Kafka api does connect to Kafka server.
