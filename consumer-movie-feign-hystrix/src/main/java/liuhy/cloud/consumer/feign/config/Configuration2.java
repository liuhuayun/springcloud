package liuhy.cloud.consumer.feign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class Configuration2 {
  @Bean
  public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
    return new BasicAuthRequestInterceptor("admin", "admin");
  }

  /**
    *  默认情况下：所有的Feign都支持Hystrix。但是我们可以自定义配置。
   * 全局禁用：在配置文件application.yml 中添加配置：feign.hystrix.enabled = false;
   * 禁用单个Feign Client对Hystrix的支持:
 * @return
 */
@Bean
  @Scope("prototype")
  public Feign.Builder feignBuilder() {
    return Feign.builder();
  }
}
