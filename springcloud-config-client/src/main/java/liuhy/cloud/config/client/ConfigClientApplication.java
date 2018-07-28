package liuhy.cloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class ConfigClientApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
 
    @Value("${name}")
    private String name;
    
    @Value("${age}")
    private Integer age;
    
    @Value("${address}")
    private String address;
    
    @RequestMapping("hello")
    public String hello() {
        return "I'm "+name+" and comefrom " +address+" age "+age;
    }
}
