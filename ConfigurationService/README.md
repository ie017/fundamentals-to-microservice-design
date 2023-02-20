
# Configuration service
## OK how you can configure this service !!

### 1 - You need to create application spring to specify your Configuration.

### 2 - Register your service, that is very important in microservice architecture, you can use consul register or eureka register also there is Zookeeper apache you can use it as register.

To use consul discovery :

```bash
  <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-consul-discovery</artifactId>
  </dependency>

```

### 3 - after this part you need to center your Configuration (you can center it as a repository git & after every change you should to create commit to update your configuration )

![Logo](https://miro.medium.com/v2/resize:fit:720/format:webp/1*JQfsaKXu6Q0JTyKhrdyi8A.png)

This is is the approach of configuration service, As you can see there is config repository to center all configuration of our services. Now config service need to know the directory of this repo and for that we can specify the path of this repository in application.properties of configure service.

To specify the path of conf repository : 

```bash
  spring.cloud.config.server.git.uri=file:/C:/Users/ie/Desktop/MecroServicesDemo/MicroserviceDesign/ConfigurationCenter
```



