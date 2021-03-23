#Architecture
***

Our sample microservice-based system consists of the following modules.
* country-service: A microservice which exposes few apis to consume country related data.
* state-service: A microservice which exposes apis to consume state related data.
* discovery-service: A service registry which enables client-side load-balancing and decouples service providers from consumers without the need for DNS.
***

##Communication between microservices with spring cloud open Feign 
* **country-service** connects to **state-service** to get the list of states. so, to communicate between the microservice we need to include additional dependency: spring-cloud-starter-openfeign.
  

* Spring Cloud Open Feign is a declarative REST client that uses Ribbon client-side load balancer in order to communicate with other microservice
````
implementation group: 'org.springframework.cloud', name: 'spring-cloud-starter-openfeign'
````
check the implementation [here](https://github.com/vishesh-awasthi/sample-spring-microservices/tree/eureka_service_registration_discovery/country-service/src/main/java/com/visheshawasthi/client)
***

We can always use ***RestTemplate*** with ***@LocaBalanced***. However, Feign provides a more elegant way of defining clients.


