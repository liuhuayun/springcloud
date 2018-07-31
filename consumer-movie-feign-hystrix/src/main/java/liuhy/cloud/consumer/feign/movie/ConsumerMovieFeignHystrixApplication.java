package liuhy.cloud.consumer.feign.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard
public class ConsumerMovieFeignHystrixApplication {
	
  /**
   * spring cloud2 hystrix没有/actuator/hystrix.stream路径解决
   * @return
   */
  @Bean
  public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet(){
	/*
	 * 访问http://localhost:8010//hystrix，输入框输入以下地址
	 * http://localhost:8010/actuator/hystrix.stream
	 * 
	 */     
	HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
     ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<HystrixMetricsStreamServlet>(streamServlet);
     registrationBean.setLoadOnStartup(1);
     registrationBean.addUrlMappings("/actuator/hystrix.stream");
     registrationBean.setName("HystrixMetricsStreamServlet");
     return registrationBean;
  }
  
  public static void main(String[] args) {
    SpringApplication.run(ConsumerMovieFeignHystrixApplication.class, args);
  }
  
}

