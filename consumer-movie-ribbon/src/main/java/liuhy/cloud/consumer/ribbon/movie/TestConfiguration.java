package liuhy.cloud.consumer.ribbon.movie;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
@ExcludeFromComponentScan
//2.使用代码方式负载均衡自定义配置
public class TestConfiguration {
  //  @Autowired
  //  IClientConfig config;
  //RoundRobinRule:轮询选择server
  //RandomRule:随机选择server
  //ZoneAvoidanceRule：复合判断server所在区域的性能和server的可用性选择server
  //WeightedResponseTimeRule：根据相应时间分配一个weight，相应时间越长，weight越小，被选中的可能性越低
  //BestAvailableRule:选择一个最小的并发请求的server
  @Bean
  public IRule ribbonRule() {
    return new RandomRule();
  }
}
