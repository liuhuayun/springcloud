package liuhy.cloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //配置自动刷新
public class ConfigController {
	
    @Value("${name}")
    private String name;
    
    @Value("${age}")
    private Integer age;
    
    @Value("${address}")
    private String address;
    
    @RequestMapping("hello")
    public String hello() {
        return "I'm "+name+" and comefrom " +address+" age "+age;
    }
}
