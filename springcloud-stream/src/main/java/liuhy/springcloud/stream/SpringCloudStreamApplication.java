package liuhy.springcloud.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import liuhy.springcloud.stream.message.StreamClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
public class SpringCloudStreamApplication {
	
	@Autowired
    private StreamClient streamClient;
	
    public static void main( String[] args ){
    	
    	SpringApplication.run(SpringCloudStreamApplication.class, args);
    }
    

    @GetMapping("send")
    public void send() {
        //User user = new User("张三", "154shmj");
        streamClient.output().send(MessageBuilder.withPayload("Hello World...").build());
//        streamClient.output().send(MessageBuilder.withPayload(user).build());
    }
}
