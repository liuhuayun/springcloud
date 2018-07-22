package liuhy.cloud.consumer.feign.movie.facade;

import org.springframework.stereotype.Component;

@Component
public class FeignClient2Fallback implements FeignClient2 {

  @Override
  public String findServiceInfoFromEurekaByServiceName(String serviceName) {
	  
    return "FeignClient2Fallback";
  }

}
