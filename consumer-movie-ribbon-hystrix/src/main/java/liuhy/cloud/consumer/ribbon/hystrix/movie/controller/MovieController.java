package liuhy.cloud.consumer.ribbon.hystrix.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import liuhy.cloud.consumer.ribbon.hystrix.movie.entity.User;

@RestController
public class MovieController {
  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/movie/{id}")
  @HystrixCommand(fallbackMethod = "findByIdFallback")
  public User findById(@PathVariable Long id) {
    return this.restTemplate.getForObject("http://service-provider-user/simple/" + id, User.class);
  }
  //服务不可用时返回值
  public User findByIdFallback(Long id) {
    User user = new User();
    user.setId(0L);
    user.setUsername("默认用户");
    return user;
  }
}
