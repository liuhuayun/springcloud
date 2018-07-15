package liuhy.cloud.consumer.feign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.Logger;

/**
 * 自定义feign的配置
 * Configuration1类的类路径不在启动类的扫描路径下，
 * 是因为如果在扫描目录下会覆盖该项目所有的Feign接口的默认配置。
 *
 */
@Configuration
public class Configuration1 {
	
  @Bean
  //使用Feign自己的注解，使用springmvc的注解就会报错
  public Contract feignContract() {
    return new feign.Contract.Default();
  }

  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }
}
