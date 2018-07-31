package liuhy.cloud.consumer.ribbon.movie.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import liuhy.cloud.consumer.ribbon.movie.entity.User;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController("/restTamplate")
public class RestTamplateController {
	
	 @Autowired
	 private RestTemplate restTemplate;
	 
	 private String url = "http://HELLO-SERVICE/hello";
	 
	 @SuppressWarnings("unused")
	@RequestMapping("/getFor")
	 public String getFor() {
		  Map<String, Object> map = new HashMap<>();
	        map.put("name", "daye");
	        map.put("age", 19);
	     ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, map);
	     String body = responseEntity.getBody();
	     HttpStatus statusCode = responseEntity.getStatusCode();
	     int statusCodeValue = responseEntity.getStatusCodeValue();
	     HttpHeaders headers = responseEntity.getHeaders();
	     StringBuffer result = new StringBuffer();
	     
	     String forObject = restTemplate.getForObject(url, String.class);
	     return forObject;
	 }
	 
	 @SuppressWarnings("unused")
	@RequestMapping("/postFor")
	 public String postFor() {
		 User user = new User();
		 user.setName("daye");
		 ResponseEntity<String> postForEntity = restTemplate.postForEntity(url, user, String.class); 
		 String body = postForEntity.getBody();
		 HttpHeaders headers = postForEntity.getHeaders();
		 int statusCodeValue = postForEntity.getStatusCodeValue();
		 //postForLocation也是提交新资源，提交成功之后，返回新资源的URI
		 URI postForLocation = restTemplate.postForLocation(url, user);
		 
		 String returnStr = restTemplate.postForObject(url, user, String.class);
		 return returnStr;
	 }
	 
	 @RequestMapping("/delete")
	 public void delete() {
		  restTemplate.delete(url);
	 }
	 
	 @RequestMapping("/put")
	 public void put() {
		 User user = new User();
		 user.setName("daye");
		 restTemplate.put(url, user);
	 }
	  /**
	   * spring直接提供了所有http的请求的公用方法exchange
	 * @return
	 * @throws JSONException
	 */
	 @RequestMapping("/exchange")
	public String exchange() throws JSONException {
		//该方法通过restTemplate请求远程restfulAPI
	      HttpHeaders headers = new HttpHeaders();
	      headers.set("auth_token", "asdfgh");
	      headers.set("Other-Header", "othervalue");
	      headers.setContentType(MediaType.APPLICATION_JSON);
	      
	      JSONObject parm = new JSONObject();
	      parm.put("parm", "1234");
	      HttpEntity<JSONObject> entity = new HttpEntity<JSONObject>(parm, headers);
	      HttpEntity<String> response = restTemplate.exchange(
	              "http://localhost:8080/headerApi", HttpMethod.POST, entity, String.class);//这里放JSONObject, String 都可以。因为JSONObject返回的时候其实也就是string
	      return response.getBody();
	  }
}
