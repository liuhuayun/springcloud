package liuhy.cloud.consumer.feign.movie.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import liuhy.cloud.provider.entity.User;

@FeignClient("service-provider-user")
public interface UserClient {
 
    @RequestMapping(method = RequestMethod.GET, value = "/getuser")
    public User getuserinfo();
     
    @RequestMapping(method = RequestMethod.GET, value = "/getuser")
    public String getuserinfostr();
     
    @RequestMapping(method = RequestMethod.GET, value = "/info")
    public  String  info();
 
}