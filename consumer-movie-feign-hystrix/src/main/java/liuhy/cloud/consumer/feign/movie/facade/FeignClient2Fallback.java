package liuhy.cloud.consumer.feign.movie.facade;

public class FeignClient2Fallback implements FeignClient2 {

  @Override
  public String findServiceInfoFromEurekaByServiceName(String serviceName) {
	  
    return "FeignClient2Fallback";
  }

}
