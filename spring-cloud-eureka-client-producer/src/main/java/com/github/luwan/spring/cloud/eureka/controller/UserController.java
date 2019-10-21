package com.github.luwan.spring.cloud.eureka.controller;

import com.github.luwan.spring.cloud.eureka.entity.User;
import com.github.luwan.spring.cloud.eureka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/simple/{id}")
  public User findById(@PathVariable Long id) {
    return this.userRepository.findOne(id);
  }
}
