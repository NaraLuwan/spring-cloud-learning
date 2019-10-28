package com.github.luwan.spring.cloud.eureka.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Luwan
 * @date 2019/10/28
 */
@Data
public class User {

  private Long id;

  private String username;

  private String name;

  private Short age;

  private BigDecimal balance;
}
