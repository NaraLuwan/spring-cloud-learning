package com.github.luwan.spring.cloud.eureka.controller;

import com.github.luwan.spring.cloud.eureka.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class UserController {

  @Autowired
  private RestTemplate template;

  @Value("${user.userServicePath}")
  private String userServicePath;

  @GetMapping("/simple/{id}")
  public User findById(@PathVariable Long id) {
    return this.template.getForObject(userServicePath+id, User.class);
  }

}
