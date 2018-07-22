package liuhy.cloud.consumer.feign.movie.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import liuhy.cloud.consumer.feign.config.Configuration2;

@FeignClient(name = "xxxx", url = "http://localhost:8761/", configuration = Configuration2.class, fallback = FeignClient2Fallback.class)
public interface FeignClient2 {
  @RequestMapping(value = "/eureka/apps/{serviceName}")
  public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
