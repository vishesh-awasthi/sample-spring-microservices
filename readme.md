#Architecture
***

Our sample microservice-based system consists of the following modules.
* country-service: A microservice which exposes few apis to consume country related data.
* state-service: A microservice which exposes apis to consume state related data.
* discovery-service: A service registry which enables client-side load-balancing and decouples service providers from
  consumers without the need for DNS.
* gateway-service: An api gateway which will route the request to different microservice based on the route configured.
***
