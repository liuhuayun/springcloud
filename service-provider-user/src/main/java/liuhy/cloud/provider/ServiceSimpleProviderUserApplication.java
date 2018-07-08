package liuhy.cloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/*如不想将服务注册到Eureka Server，
只需设置spring.cloud.service-registry.auto-registration.enabled=false ，
或@EnableDiscoveryClient(autoRegister = false) 即可。*/

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
//服务提供者
public class ServiceSimpleProviderUserApplication {
	
  public static void main(String[] args) {
    SpringApplication.run(ServiceSimpleProviderUserApplication.class, args);
  }
}
