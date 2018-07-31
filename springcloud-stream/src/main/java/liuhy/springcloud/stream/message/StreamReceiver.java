package liuhy.springcloud.stream.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * 创建消费者，并绑定通道
 *
 */
@Component
@EnableBinding(value= {StreamClient.class}) //用来指定一个或多个定义了@Input 或者 @Output注解的接口，实现对消息通道的绑定。
public class StreamReceiver {
	
	private static Logger logger = LoggerFactory.getLogger(StreamReceiver.class);
	
    @StreamListener(StreamClient.INPUT) // "input" 通道监听,接受管道推送的消息
    public void receive(Object message) {

        logger.info("Received: " + message);

    }
}
