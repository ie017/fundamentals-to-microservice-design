# Configuration service offered by consul api : 
### 1 - To use this api we need to add this maven dependency : 
```bash
  <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-consul-config</artifactId>
  </dependency>
```

### 2 - Go and create your configuration in consul UI, chose key/value in the menu and create folder of our app : config/customer-service
### 3 - Create all properties you want in the specific folder, in my example I create : 
```bash
value.username
value.password
```

### 4 - Create class to take these properties from consul localhost : 
```bash
@Component
/*Pour prendre les proprieties qui débuter par value dans notre file : customer-service dans consul*/
@ConfigurationProperties(prefix = "value")
@Data
public class ConsulConfig {
    private String username;
    private String password;
}
```
With <font color="yellow">ConfigurationProperties</font>, you can define a class with fields that match the properties you want to bind, and annotate it with the @ConfigurationProperties annotation. When Spring creates an instance of that class, it automatically binds the corresponding properties to the fields.

This feature is particularly useful when dealing with external configuration sources such as properties files, YAML files, environment variables, or command-line arguments. By using ConfigurationProperties, you can centralize and organize all your configuration properties in a structured and type-safe way, and make them available to your Spring beans.
### 5 - You can inject this configuration in all classes, in our example we will do it to show the values of our properties :
```bash
@RestController
@EnableConfigurationProperties(value = ConsulConfig.class)
public class ReceiveConsulConfigRestController {
    @Autowired
    private ConsulConfig consulConfig;

    @GetMapping("/consulconfig")
    public ConsulConfig ReceiveConfig(){
        return consulConfig;
    }
}
```
### 6 - Check the result : 
![plot](C:\Users\ie\Desktop\MecroServicesDemo\CustomerService\ConsulConfigTest.png)

###### REMARK : We don't need to actuator or refreshScope to update the values of our properties just cha,ge it from consul ui, and they will be change automatically in our application.