package liuhy.cloud.consumer.feign.movie.facade;

import liuhy.cloud.consumer.feign.config.Configuration1;
import liuhy.cloud.consumer.feign.movie.entity.User;

import org.springframework.cloud.openfeign.FeignClient;

import feign.Param;
import feign.RequestLine;
//自定义feign 配置
@FeignClient(name="service-provider-user",configuration=Configuration1.class)
public interface UserFeignClient1 {
	
  @RequestLine("GET /simple/{id}")
  public User findById(@Param("id") Long id); 

}