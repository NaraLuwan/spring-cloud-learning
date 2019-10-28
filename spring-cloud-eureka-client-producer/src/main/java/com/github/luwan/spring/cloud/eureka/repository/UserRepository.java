package com.github.luwan.spring.cloud.eureka.repository;

import com.github.luwan.spring.cloud.eureka.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Luwan
 * @date 2019/10/28
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
