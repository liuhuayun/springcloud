package liuhy.springcloud.stream.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 发布者和订阅者接口
 *
 */
public interface StreamClient {
	
    String INPUT = "myInput";
    String OUTPUT = "myOutput";
    
    @Input(StreamClient.INPUT) //@Input表示绑定订阅输入管道，通过管道接受来自发布者的消息
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT) //@output注解表示绑定输出管道，通过管道发布消息。
    MessageChannel output();
}
