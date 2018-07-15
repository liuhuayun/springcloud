package liuhy.cloud.consumer.feign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

/**
 * 因为Eureka配置了用户名和密码，
 * 所有这个FeignClient也自己定义了FeignClientsConfiguration，也可以用来访问Eureka服务接口
 *
 */
@Configuration
public class Configuration2 {
	
  @Bean
  public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
    return new BasicAuthRequestInterceptor("admin", "admin");
  }
}
