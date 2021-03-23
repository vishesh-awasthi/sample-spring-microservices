###Architecture
***

Our sample microservice-based system consists of the following modules.
* country-service: A microservice which exposes few apis to consume country related data.
* state-service: A microservice which exposes apis to consume state related data.
***

Right now both microservice are not using any database to store the data.

This is the simplest example of two microservices communicating with each other. Down the line we will introduce other compoments which will enhance our architecture.

Final architecture will have many other components like gate-service, discovery-service, config-service, zuul, ribbon....