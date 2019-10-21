package com.github.luwan.spring.cloud.eureka.repository;

import com.github.luwan.spring.cloud.eureka.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
