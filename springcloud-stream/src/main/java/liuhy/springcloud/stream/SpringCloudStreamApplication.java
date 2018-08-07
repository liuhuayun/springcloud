package liuhy.springcloud.stream;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import liuhy.springcloud.stream.message.StreamClient;
import liuhy.springcloud.stream.message.User;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
public class SpringCloudStreamApplication {
	
	@Autowired
    private StreamClient streamClient;
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate ;
	
    public static void main( String[] args ){
    	
    	SpringApplication.run(SpringCloudStreamApplication.class, args);
    }
    

    @GetMapping("send")
    public void send() {
    	kafkaTemplate.send("springstream-topic","hello");
    	User user = new User("路班","123");
    	Message<User> msg = MessageBuilder.withPayload(user).build();
    	streamClient.output().send(msg);
    	//kafkaTemplate.send("topic-test", "hello");
        //User user = new User("张三", "154shmj");
        //streamClient.output().send(MessageBuilder.withPayload("Hello World...").build());
//        streamClient.output().send(MessageBuilder.withPayload(user).build());
    }
    
}
