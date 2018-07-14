package liuhy.cloud.provider.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import liuhy.cloud.provider.entity.User;
import liuhy.cloud.provider.repository.UserRepository;

@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private EurekaClient eurekaClient;

  @Autowired
  private DiscoveryClient discoveryClient;

  @GetMapping("/simple/{id}")
  public User findById(@PathVariable Long id) {
    return this.userRepository.getOne(id);
  }

  @GetMapping("/eureka-instance")
  public String serviceUrl() {
    InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("SERVICE-PROVIDER-USER", false);
    return instance.getHomePageUrl();
  }

  @GetMapping("/instance-list")
  public List<String> instanceList() {
	  List<String> services = discoveryClient.getServices();
    //List<ServiceInstance> localServiceInstances = this.discoveryClient.getInstances(serviceId);
    return services;
  }
  
  @GetMapping("/instance-info")
  public List<ServiceInstance>  instanceInfo() {
	  List<ServiceInstance> instances = discoveryClient.getInstances("service-provider-user");
    return instances;
  }
  @PostMapping("/user")
  public User postUser(@RequestBody User user) {
    return user;
  }

  // 该请求不会成功
  @GetMapping("/get-user")
  public User getUser(User user) {
    return user;
  }

  @GetMapping("list-all")
  public List<User> listAll() {
    List<User> list = userRepository.findAll();
    return list;

  }
}
