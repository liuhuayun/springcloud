package liuhy.cloud.consumer.feign.movie.facade;

import org.springframework.stereotype.Component;

import liuhy.cloud.consumer.feign.movie.entity.User;

@Component
public class HystrixClientFallback implements UserFeignClient {

	@Override
	public User findById(Long id) {
		User user = new User();
		user.setId(0L);
		user.setUsername("默认用户1");
		return user;
	}

	@Override
	public User postUser(User user) {
		return null;
	}

	@Override
	public User getUser(User user) {
		return null;
	}
}