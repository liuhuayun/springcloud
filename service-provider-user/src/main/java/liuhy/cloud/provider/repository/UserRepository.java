package liuhy.cloud.provider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import liuhy.cloud.provider.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
