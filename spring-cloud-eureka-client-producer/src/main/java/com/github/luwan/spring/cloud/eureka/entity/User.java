package com.github.luwan.spring.cloud.eureka.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Luwan
 * @date 2019/10/28
 */
@Entity
@Data
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String username;

  @Column
  private String name;

  @Column
  private Short age;

  @Column
  private BigDecimal balance;
}
