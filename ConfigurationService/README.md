
# Configuration service
## Use Spring cloud config :

### 1 - You need to create application spring to specify your Configuration.

### 2 - Register your service, that is very important in microservice architecture, you can use consul register or eureka register also there is Zookeeper apache you can use it as register.

To use consul discovery :

```bash
  <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-consul-discovery</artifactId>
  </dependency>

```

### 3 - After this part you need to center your Configuration (you can center it as a repository git & after every change you should to create commit to update your configuration )

![Logo](https://miro.medium.com/v2/resize:fit:720/format:webp/1*JQfsaKXu6Q0JTyKhrdyi8A.png)

This is is the approach of configuration service, As you can see there is config repository to center all configuration of our services. Now config service need to know the directory of this repo and for that we can specify the path of this repository in application.properties of configure service.

To specify the path of conf repository : 

```bash
  spring.cloud.config.server.git.uri=file:/C:/Users/ie/Desktop/MecroServicesDemo/MicroserviceDesign/ConfigurationCenter
```

### 4 - Our goal is how we can get the configuration of a service, For example service1 need to know his configuration so for that we need to specify the path of config service's local.

Use it in customer service'application.properties to take his config from config service.
```bash
  spring.config.import=optional:configserver:http://localhost:8089
```
Now the problem is when the configuration starts updating (do the change & commit it), customer service need to take the new configuration & that doesn't happen automatically, Actually we need to run customer service everytime we change the configuration & that doesn't support design of microservice because we want to stop running and stopping our services everytime.
The solution is use actuator.

### What is actuator ?
In the Spring Framework, an actuator is a tool that provides production-ready features to help monitor and manage your application. It exposes a set of HTTP endpoints or management endpoints (URI that provides a way to interact with an application through HTTP requests) that can be used to view or change application state, perform health checks, and interact with various aspects of the application.

Actuators can be used to monitor and manage various aspects of the application, such as database connections, caches, message queues, and more. Some of the commonly used endpoints include:

/actuator/health: Provides information about the health of the application, including its status, details, and any errors that have occurred.

/actuator/info: Provides custom application information, such as version number or build details.

/actuator/metrics: Provides metrics about the application, such as the number of requests processed or the amount of memory used.

/actuator/auditevents: Provides information about security-related events, such as login attempts and other authentication-related events.

Actuators are enabled by default in Spring Boot applications, but can also be configured and customized to meet your specific needs.

### 5 - Use actuator to refresh customer service without stop running of the server :

To do this part we need to send request to :
```bash
  POST http://localhost:9091/actuator/refresh
```
This operation to make our service able to take information about the last change in his application.properties from config service.

Before that we need to use :
```bash
  management.endpoints.web.exposure.include=*
```
That mean all endpoints in Spring Boot Actuator should be exposed over HTTP.

We should use @RefreshScope in ReceiveConfigRestController, go & check it.


## REMARK : You can use consul to create a configuration of all services. To learn more, just check README in the CustomerService folder.