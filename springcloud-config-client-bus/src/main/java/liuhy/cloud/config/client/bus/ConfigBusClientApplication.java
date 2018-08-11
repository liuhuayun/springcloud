package liuhy.cloud.config.client.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigBusClientApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(ConfigBusClientApplication.class, args);
    }
}
