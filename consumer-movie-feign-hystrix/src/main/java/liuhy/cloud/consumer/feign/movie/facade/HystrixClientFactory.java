package liuhy.cloud.consumer.feign.movie.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
import liuhy.cloud.consumer.feign.movie.entity.User;

/**
 * 定义fallback方法，同时打印Fallback的原因
 * 
 * @author Administrator
 *
 */
@Component
public class HystrixClientFactory implements FallbackFactory<UserFeignClient> {

	private static final Logger log = LoggerFactory.getLogger(HystrixClientFactory.class);

	@Override
	public UserFeignClient create(Throwable cause) {
		log.info("fallback; reason was: {}", cause.getMessage());
		return new UserFeignClientWithFactory() {
			@Override
			public User findById(Long id) {
				User user = new User();
				user.setId(-1L);
				return user;
			}

			@Override
			public User postUser(User user) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public User getUser(User user) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

}
