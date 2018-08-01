package liuhy.cloud.consumer.feign.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import liuhy.cloud.consumer.feign.movie.entity.User;
import liuhy.cloud.consumer.feign.movie.facade.UserFeignClient;
import liuhy.cloud.consumer.feign.movie.facade.UserFeignClient1;
import liuhy.cloud.consumer.feign.movie.facade.UserFeignClient2;

@RestController
public class MovieController {

  @SuppressWarnings("unused")
@Autowired
  private UserFeignClient userFeignClient;//默认的
  
  @Autowired
  private UserFeignClient1 userFeignClient1;//自定义配置
  
  @Autowired
  private UserFeignClient2 userFeignClient2;//默认的配置
  
  /*@GetMapping("/movie/{id}")
  public User findById(@PathVariable Long id) {
    return this.userFeignClient.findById(id);
  }

  @GetMapping("/test")
  public User testPost(User user) {
    return this.userFeignClient.postUser(user);
  }

  @GetMapping("/test-get")
  public User testGet(User user) {
    return this.userFeignClient.getUser(user);
  }*/
  
  @GetMapping("/movie1/{id}")
  public User findById1(@PathVariable Long id) {
    return this.userFeignClient1.findById(id);
  }
  
  @GetMapping("/{serviceName}")
  public String findServiceInfoFromEurekaByServiceName(@PathVariable String serviceName) {
    return this.userFeignClient2.findServiceInfoFromEurekaByServiceName(serviceName);
  }
}