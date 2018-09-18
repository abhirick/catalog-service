#Catalog Service

# Spring BOOT Micro Services based Application

## Info - A Microserice to access available catalog entities. Catalog microserive can provide details about catalog entities like Catalogs, Categories, Products, Sku's, Inventory, Pricing etc.

### Develop
- [Git](http://git-scm.com/downloads)
- [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Spring Boot](http://docs.spring.io/spring-boot)
- [Cassandra]
- [Spring-Security]
- [Maven]

### Deployment
- The Application runs on Embedded Tomcat Server
- Server Port- 8086
- Packaging - Jar

### Cassandra DB Configuration
- cassandra.contactpoints=localhost
- cassandra.port=9042
- cassandra.keyspace=enterprise_services

### Application URL
- [Actuator] http://localhost:8086/actuator/index.html#/actuator
- [Swagger] http://localhost:8086/swagger-ui.html#/ - All the Catalog Service API's are listed in the Swagger UI.
- [Spring REST Docs] http://localhost:8086/docs/index.html

# catalog-service
