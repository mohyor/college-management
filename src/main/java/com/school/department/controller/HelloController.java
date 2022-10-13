package com.school.department.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {

 @Value("${welcome.message}")
 private String welcomeMessage;

 @GetMapping("/")
 public String hello() {
  return welcomeMessage;
 }
}
